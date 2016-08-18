import java.security.*;
import javax.crypto.*;
import java.io.*;

// Import a package for BASE64 encoding.
// If sun.misc doesn't work for you, replace it with
// the line following
import sun.misc.*;
// import com.isnetworks.base64.*;

/**
 *	KeyStoreExample.java
 *
 *	Encrypts or decrypts a string from STDIN using a
 *	128-bit Blowfish key. That key is stored to the
 *	standard KeyStore in the filesystem.
 */
public class KeyStoreExample
{
  private static String FILENAME = "keystore.ks";

  public static void main(String[] args)
  throws Exception
  {
    if (args.length != 3)
    {
      System.err.println("Usage: java KeyStoreExample -e|-d password text");
      System.exit(1);
    }

    // Convert the password into a char array
    char[] password = new char[args[1].length()];
    args[1].getChars(0, args[1].length(), password, 0);

    String text = args[2];

    // Check if the user wants to encrypt or decrypt
    if (args[0].equals("-e")) encrypt(password, text);
    else decrypt(password, text);

  }

  /**
   *	Encrypts the plaintext passed in and outputs
   *	the ciphertext to STDOUT. Also stores the secret key
   *	to the filesystem inside a KeyStore.
   */
  private static void encrypt(char[] password, String plaintext)
  throws Exception
  {
    System.out.println("Generating a TripleDES key...");

    // Create a Blowfish key
    KeyGenerator keyGenerator = KeyGenerator.getInstance("TripleDES");
    keyGenerator.init(168);
    Key key = keyGenerator.generateKey();

    System.out.println("Done generating the key.");

    // Create a cipher using that key to initialize it
    Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    byte[] plaintextBytes = plaintext.getBytes();

    // Perform the actual encryption
    byte[] cipherText = cipher.doFinal(plaintextBytes);

    // Now we need to Base64-encode it for ascii display
    BASE64Encoder encoder = new BASE64Encoder();
    String output = encoder.encode(cipherText);

    System.out.println("Ciphertext: "+output);

    /* Create a keystore and place the key in it
     * We're using a jceks keystore, which is provided by Sun's JCE.
     * If you don't have the JCE installed, you can use "JKS",
     * which is the default keystore. It doesn't provide
     * the same level of protection however.
     */
    KeyStore keyStore = KeyStore.getInstance("JKS");

    // This initializes a blank keystore
    keyStore.load(null, null);

    // Now we add the key to the keystore, protected
    // by the password.
    keyStore.setKeyEntry("exampleKey", key, password, null);

    // Store the password to the filesystem, protected
    // by the same password.
    FileOutputStream fos = new FileOutputStream(FILENAME);
    keyStore.store(fos, password);
    fos.close();
  }

  /**
   *	Decrypts the ciphertext passes in and prints the plaintext
   *	to STDOUT. Pulls a key from a KeyStore in the filesystem,
   *	using the password given.
   */
  private static void decrypt(char[] password, String ciphertext)
  throws Exception
  {
    // Create a keystore and load it from the filesystem,
    // using the password given.
    KeyStore keyStore = KeyStore.getInstance("JKS");
    FileInputStream fis = new FileInputStream(FILENAME);
    keyStore.load(fis, password);
    fis.close();
    Key key = (Key)keyStore.getKey("exampleKey",password);

    // Create a cipher using that key to initialize it
    Cipher cipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
    cipher.init(Cipher.DECRYPT_MODE, key);

    // Perform the decryption, first BASE64 decoding the ciphertext
    byte[] ciphertextBytes = new BASE64Decoder().decodeBuffer(ciphertext);
    byte[] decryptedText = cipher.doFinal(ciphertextBytes);

    String output = new String(decryptedText);

    System.out.println("Plaintext: "+output);
  }
}
