import java.io.*;
import java.net.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;

/**
 *	SignatureAuthenticationClient
 *
 *	This class attaches to a SignatureAuthenticationServer
 *	and uses a digital signature to authentitate itself.
 */
public class SignatureAuthenticationClient {

  private static final int PORT = 8001;

  private static final int MD5_ITERATIONS = 1000;

  /**
   *	First arg is hostname
   */
  public static void main (String[] args) throws Exception {
	if (args.length != 1) {
		System.err.println("Usage: java AuthenticationClient hostname");
		System.exit(1);
	}

    String hostname = args[0];
    // Begin by asking for the private key's filename
    BufferedReader in = new BufferedReader
    (new InputStreamReader(System.in));
    System.out.print("Private Key: ");
    String privateKeyFilename = in.readLine();
    System.out.print("Password: ");
    String password = in.readLine();

    // Get the private key
    PrivateKey privateKey = getPrivateKey
    	(privateKeyFilename, password.toCharArray());

    System.out.println("\nOpening a connection...");
    // Open up a connection
    Socket socket = new Socket(hostname, PORT);

    DataInputStream inputFromServer = new
    	DataInputStream(socket.getInputStream());
    DataOutputStream outputToServer = new
    	DataOutputStream(socket.getOutputStream());

    // Receive byte array to sign
    byte[] dataToBeSigned = new byte[inputFromServer.readInt()];
    inputFromServer.readFully(dataToBeSigned);

    // Now sign it
    Signature signature = Signature.getInstance("MD5WithRSA");
    signature.initSign(privateKey);
    signature.update(dataToBeSigned);
    byte[] signatureBytes = signature.sign();

    // Write out the signature bytes
    outputToServer.writeInt(signatureBytes.length);
    outputToServer.write(signatureBytes);
    outputToServer.flush();

    boolean verified = inputFromServer.readBoolean();

    if (verified) {
      System.out.println("We were authenticated.");
    } else {
      System.out.println("Permission denied.");
    }
  }

  private static PrivateKey getPrivateKey(
	  String privateKeyFilename, char[] password)
  throws Exception {

    // Load the private key bytes
    FileInputStream fis = new FileInputStream(privateKeyFilename);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    int theByte = 0;
    while ((theByte = fis.read()) != -1)
    {
      baos.write(theByte);
    }
    fis.close();

    byte[] keyBytes = baos.toByteArray();
    baos.close();

    keyBytes = passwordDecrypt(password, keyBytes);

    // Turn the encoded key into a real RSA private key.
    // Private keys are encoded in PKCS#8.
    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
    return privateKey;
  }

  private static byte[] passwordDecrypt(
	  char[] password, byte[] ciphertext)
  throws Exception {

    // Read in the salt.
    byte[] salt = new byte[8];
    ByteArrayInputStream bais = new ByteArrayInputStream(ciphertext);
    bais.read(salt,0,8);

    // The remaining bytes are the actual ciphertext.
    byte[] remainingCiphertext = new byte[ciphertext.length-8];
    bais.read(remainingCiphertext,0,ciphertext.length-8);

    // Create a PBE cipher to decrypt the byte array.
    PBEKeySpec keySpec = new PBEKeySpec(password);
    SecretKeyFactory keyFactory =
    	SecretKeyFactory.getInstance("PBEWithSHAAndTwofish-CBC");
    SecretKey key = keyFactory.generateSecret(keySpec);
    PBEParameterSpec paramSpec = new PBEParameterSpec
    	(salt, MD5_ITERATIONS);
    Cipher cipher = Cipher.getInstance("PBEWithSHAAndTwofish-CBC");

    // Perform the actual decryption.
    cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
    return cipher.doFinal(remainingCiphertext);
  }
}
