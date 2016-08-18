import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class GenerateKeyPair {

  private static final int MD5_ITERATIONS = 1000;

  public static void main(String[] args) throws Exception {
    createKeyPair();
  }

  private static void createKeyPair()
  throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Password to encrypt the private key: ");
    String password = in.readLine();
    System.out.println("Generating an RSA keypair...");

    // Create an RSA key
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(1024);
    KeyPair keyPair = keyPairGenerator.genKeyPair();

    System.out.println("Done generating the keypair.\n");

    // Now we need to write the public key out to a file
    System.out.print("Public key filename: ");
    String publicKeyFilename = in.readLine();

    byte[] publicKeyBytes = keyPair.getPublic().getEncoded();

    FileOutputStream fos = new FileOutputStream(publicKeyFilename);
    fos.write(publicKeyBytes);
    fos.close();

    // Now we need to do the same thing with the private key,
    // but we need to password encrypt it as well.
    System.out.print("Private key filename: ");
    String privateKeyFilename = in.readLine();

    // Get the encoded form. This is PKCS#8 by default.
    byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();

    // Here we actually encrypt the private key
    byte[] encryptedPrivateKeyBytes =
    passwordEncrypt(password.toCharArray(),privateKeyBytes);

    fos = new FileOutputStream(privateKeyFilename);
    fos.write(encryptedPrivateKeyBytes);
    fos.close();
  }

  /**
   *	Utility method to encrypt a byte array with a given password.
   *	Salt will be the first 8 bytes of the byte array returned.
   */
  private static byte[] passwordEncrypt(
	  char[] password, byte[] plaintext) throws Exception {

    // Create the salt.
    byte[] salt = new byte[8];
    SecureRandom random = new SecureRandom();
    random.nextBytes(salt);

    // Create a PBE key and cipher.
    PBEKeySpec keySpec = new PBEKeySpec(password);
    SecretKeyFactory keyFactory =
    	SecretKeyFactory.getInstance("PBEWithSHAAndTwofish-CBC");
    SecretKey key = keyFactory.generateSecret(keySpec);
    PBEParameterSpec paramSpec = new PBEParameterSpec(salt, MD5_ITERATIONS);
    Cipher cipher = Cipher.getInstance("PBEWithSHAAndTwofish-CBC");
    cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

    // Encrypt the array
    byte[] ciphertext = cipher.doFinal(plaintext);

    // Write out the salt, then the ciphertext and return it.
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    baos.write(salt);
    baos.write(ciphertext);
    return baos.toByteArray();
  }

}