import java.security.*;
import javax.crypto.*;
import sun.misc.*;

/**
 *	KeysizeExample.java
 *
 *	This class creates a Blowfish key, encrypts some text,
 *	prints the ciphertext, then decrypts the text and
 *	prints that. The interesting thing to note is that we
 *	actually define the size of the key to be created,
 *	to 256 bits (Blowfish's maximum).
 *
 *	It requires a JCE-compliant Blowfish engine, like Sun's JCE.
 */
public class KeysizeExample
{
  public static void main (String[] args)
  throws Exception
  {
    if (args.length != 1) {
      System.err.println("Usage: java KeysizeExample text");
      System.exit(1);
    }
    String text = args[0];
    String output = null;

    System.out.println("Generating a 256-bit Blowfish key...");


    // Create a Blowfish key
    KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");

    // Now set the keysize to 256 bits
    keyGenerator.init(256);

    Key key = keyGenerator.generateKey();

    System.out.println("Done generating the key.");

    // Create a cipher using that key to initialize it
    Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);

    byte[] textBytes = text.getBytes();

    // Perform the actual encryption
    byte[] cipherText = cipher.doFinal(textBytes);

    // Now we need to Base64-encode it for ascii display
    BASE64Encoder encoder = new BASE64Encoder();
    output = encoder.encode(cipherText);

    System.out.println("Ciphertext: "+output);

    // Re-initialize the cipher to decrypt mode
    cipher.init(Cipher.DECRYPT_MODE, key);

    // Perform the decryption
    byte[] decryptedText = cipher.doFinal(cipherText);

    output = new String(decryptedText);

    System.out.println("Plaintext: "+output);


  }
}