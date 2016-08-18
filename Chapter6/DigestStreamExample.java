import java.security.MessageDigest;
import java.security.DigestInputStream;
import java.io.*;
import sun.misc.*;

/**
 *	DigestFile
 *
 *	This class creates an MD5 message digest from a file
 *	and displays it to the screen BASE64 Encoded.
 */
public class DigestStreamExample {

  /**
   *	The only argument is the name of the file to be digested.
   */
  public static void main (String[] args) throws Exception {

    if (args.length != 1) {
      System.err.println("Usage: java DigestFile filename");
      System.exit(1);
    }

    // Create a message digest
    MessageDigest md = MessageDigest.getInstance("MD5");

    BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[0]));

	// Create a DigestInputStream
	DigestInputStream digestIn = new DigestInputStream(in, md);

	// Now read all the data, which will automatically be digested
	while (digestIn.read() != -1);

    byte[] theDigest = md.digest();

    System.out.println(new BASE64Encoder().encode(theDigest));
  }
}

