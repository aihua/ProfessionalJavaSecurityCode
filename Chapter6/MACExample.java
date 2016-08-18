import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.security.SecureRandom;
import sun.misc.*;

/**
 *	MACExample
 *
 *	This class generates a MAC key and then computes a MAC based
 *	on that and any text that the user enters as the first argument.
 */
public class MACExample {

  public static void main (String[] args)
  throws Exception {

    if (args.length != 1) {
      System.err.println("Usage: java MACExample text");
      System.exit(1);
    }

    // Generate a secret MAC key
    SecureRandom random = new SecureRandom();
    byte[] keyBytes = new byte[20];
    random.nextBytes(keyBytes);
    SecretKeySpec key = new SecretKeySpec(keyBytes, "HMACSHA1");

    System.out.println("Key: "+new BASE64Encoder().encode(key.getEncoded()));

    // Create and initialize a MAC with the key
    Mac mac = Mac.getInstance("HMACSHA1");
    mac.init(key);
    mac.update(args[0].getBytes("UTF8"));
    byte[] result = mac.doFinal();

    // Print out the resulting MAC
    System.out.println("MAC: "+new BASE64Encoder().encode(result));
  }
}