import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import sun.misc.*;

/**
 *	SimpleRSAExample.java
 *
 *	This is an example of using RSA to encrypt
 *	a single symmetric key.
 */
public class SimpleRSAExample
{
  public static void main (String[] args)
  throws Exception
  {
    // Create a Blowfish key to be encrypted
    System.out.println("Generating a symmetric (Blowfish) key...");
    KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
    keyGenerator.init(128);
    Key blowfishKey = keyGenerator.generateKey();

    System.out.println("Format: "+blowfishKey.getFormat());

    System.out.println("Generating an RSA key...");


    // Create an RSA key pair
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(1024);
    KeyPair keyPair = keyPairGenerator.genKeyPair();

    System.out.println("Done generating the key.");

    /* Create a cipher using the public key to initialize it.
     * We use Electronic CodeBook mode and PKCS1Padding. ECB
     * is good for encrypting small blocks of random data,
     * like a key.
     * PKCS1Padding is standard for most implementations of RSA */
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());

    // Get the bytes of the blowfish key
    byte[] blowfishKeyBytes = blowfishKey.getEncoded();

    // Perform the actual encryption on those bytes
    byte[] cipherText = cipher.doFinal(blowfishKeyBytes);

    // Re-initialize the RSA cipher to decrypt mode
    cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());

    // Perform the decryption
    byte[] decryptedKeyBytes = cipher.doFinal(cipherText);

    // Create a new key from the decrypted bytes using SecretKeySpec
    SecretKey newBlowfishKey = new SecretKeySpec(decryptedKeyBytes, "Blowfish");

  }
}