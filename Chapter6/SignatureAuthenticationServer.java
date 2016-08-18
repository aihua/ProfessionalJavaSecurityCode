import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import java.security.spec.*;

/**
 *	SignatureAuthenticationServer
 *
 *	This class performs authentication using digital signature.
 *	It opens a server socket and waits for connections from
 *	clients.
 */
public class SignatureAuthenticationServer extends Thread {

  private static final int PORT = 8001;

  private Socket mSocket;
  private PublicKey mPublicKey;

  public SignatureAuthenticationServer (Socket socket, PublicKey publicKey) {
    mSocket = socket;
    mPublicKey = publicKey;
    this.start();
  }

  public void run() {
    try {
      /**
       *	This is an array that will be passed
       *	to the client for signing. It consists
       *	of an 8-byte timestamp followed by a
       *	16-byte random number.
       */
      byte[] dataToBeSigned;

      // Get our input and output streams from the socket
      DataInputStream inputFromClient = new
      	DataInputStream(mSocket.getInputStream());
      DataOutputStream outputToClient = new
      	DataOutputStream(mSocket.getOutputStream());

      // Create a timestamp and write it to an array
      long timestamp = System.currentTimeMillis();
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(baos);
      dos.writeLong(timestamp);

      // Create a random value
      byte[] randomValue = new byte[16];
      SecureRandom random = new SecureRandom();
      random.nextBytes(randomValue);

      baos.write(randomValue);

      dataToBeSigned = baos.toByteArray();

      // Send that array, length first so the client knows
      // how much data to sign
      outputToClient.writeInt(dataToBeSigned.length);
      outputToClient.write(dataToBeSigned);
      outputToClient.flush();

      // Now read in the length of the signature,
      // followed by the signature
      byte[] signatureBytes = new byte[inputFromClient.readInt()];
      inputFromClient.readFully(signatureBytes);

      // Now we need to validate the signature
      Signature signature = Signature.getInstance("MD5WithRSA");
      signature.initVerify(mPublicKey);
      signature.update(dataToBeSigned);
      boolean authorized = false;
      try {
        authorized = signature.verify(signatureBytes);
      } catch (SignatureException se) {
        // In case the signature is padded incorrectly
        // this can happen if the client is using the wrong key.
      }

      outputToClient.writeBoolean(authorized);

      if (authorized) {
        System.out.println("Client was authorized.\n");
      } else {
        System.out.println("Access denied.\n");
      }
    } catch (Exception e) {
      System.err.println("Exception: ");
      e.printStackTrace();
    }
  }

  /**
   *	Waits on a port and creates a new SignatureAuthenticationServer
   *	for each request.
   */
  public static void main (String[] args) throws Exception {

    // Begin by asking for the public key's filename
    BufferedReader in = new BufferedReader
    (new InputStreamReader(System.in));
    System.out.print("Public Key of client: ");
    String publicKeyFilename = in.readLine();

    PublicKey publicKey = readPublicKey(publicKeyFilename);

    // Now initialize SecureRandom, so that future requests will be fast
    System.out.println("Initializing SecureRandom...");
    SecureRandom random = new SecureRandom();
    byte[] randomBytes = new byte[20];
    random.nextBytes(randomBytes);

    // Open up a port and create a new server to handle
    // each request as it comes in.
    ServerSocket ss = new ServerSocket(PORT);
    System.out.println("Listening on port "+PORT);

    while (true) {
      SignatureAuthenticationServer sas =
      new SignatureAuthenticationServer
      (ss.accept(), publicKey);
    }
  }

  /**
   *	Read a public key from the file system.
   */
  private static PublicKey readPublicKey(String filename) throws Exception {

    FileInputStream fis = new FileInputStream(filename);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    int theByte = 0;
    while ((theByte = fis.read()) != -1)
    {
      baos.write(theByte);
    }
    fis.close();

    byte[] keyBytes = baos.toByteArray();
    baos.close();

    // Turn the encoded key into a real RSA public key.
    // Public keys are encoded in X.509.
    X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PublicKey publicKey = keyFactory.generatePublic(keySpec);
    return publicKey;
  }
}