import java.security.*;
import java.io.*;
import java.util.*;

/**
 *	PasswordAuthenticator
 *
 *	This class creates and authenticates passwords.
 *
 *	A password is stored hashed in the file "password". It can
 *	then be validated with the command-line switch "-a".
 */
public class PasswordAuthenticator {

  /**
   *	Two possible modes of execution:
   *
   *	-c password		Create a password.
   *	-a password		Authenticate the password.
   */
  public static void main (String[] args)
  throws Exception {

    if (args.length != 2) {
      System.err.println("Usage: java PasswordAuthenticator -c|-a password");
      System.exit(1);
    }

    if ("-c".equals(args[0])) {
      createPassword(args[1]);
    } else {
      authenticatePassword(args[1]);
    }
  }

  /**
   *	Create a hashed password and store it to the filesystem
   *	in a file named "password".
   *
   *	The password will have a 16-byte salt prepended to it, and
   *	then be hashed with MD5. It will then have the salt prepended to
   *	the hash in cleartext, so that the salt is available for validation.
   */
  private static void createPassword(String password)
  throws Exception {

    // Create a new salt
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[12];
    random.nextBytes(salt);

    // Get a MessageDigest object
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(salt);
    md.update(password.getBytes("UTF8"));
    byte[] digest = md.digest();

    // Open up the password file and write the salt and the digest to it.
    FileOutputStream fos = new FileOutputStream("password");
    fos.write(salt);
    fos.write(digest);
    fos.close();
  }

  /**
   *	Check that a password is correct against the one
   *	stored in the filesystem.
   */
  private static void authenticatePassword(String password)
  throws Exception {

    // Read in the byte array from the file "password"
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    FileInputStream fis = new FileInputStream("password");
    int theByte = 0;
    while ((theByte = fis.read()) != -1)
    {
      baos.write(theByte);
    }
    fis.close();
    byte[] hashedPasswordWithSalt = baos.toByteArray();
    baos.reset();

    byte[] salt = new byte[12];
    System.arraycopy(hashedPasswordWithSalt,0,salt,0,12);

    // Get a message digest and digest the salt and
    // the password that was entered.
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(salt);
    md.update(password.getBytes("UTF8"));
    byte[] digest = md.digest();

	// Get the byte array of the hashed password in the file
    byte[] digestInFile = new byte[hashedPasswordWithSalt.length-12];
    System.arraycopy(hashedPasswordWithSalt,12,
    digestInFile,0,hashedPasswordWithSalt.length-12);

    // Now we have both arrays, we need to compare them.

    if (Arrays.equals(digest, digestInFile)) {
      System.out.println("Password matches.");
    } else {
      System.out.println("Password does not match");
    }
  }
}
