import java.io.*;
import java.util.*;
import java.security.*;

/**
 *	This class logs entries to a file "log.txt" in the user's home directory.
 *	It stores the date along with whatever String the caller requests.
 */
public class Log {

	private static final String FILENAME = "log.txt";

	/**
	 *	Add an entry to the log file, along with a
	 *	timestamp of the current time.
	 */
	public static void logAction(String text) {

		class LogPrivilegedAction implements PrivilegedAction {

			private String mText;

			public LogPrivilegedAction (String textArgument) {
				this.mText = textArgument;
			}

			public Object run() {
				// File should go in the user's home directory
				String home = System.getProperty("user.home");
				String fileSeparator = System.getProperty("file.separator");
				String filename = home+fileSeparator+FILENAME;

				// Need to log date
				Date date = new Date();

				String textToBeWritten = date + ": " + mText;

				// Open file for appending
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(filename, true);
					PrintWriter out = new PrintWriter(fos);
					out.println(textToBeWritten);
					out.close();
				} catch (FileNotFoundException fnfe) {
					System.err.println("Log: could not open file: "+filename);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
				return null;
			}
		}
		AccessController.doPrivileged(new LogPrivilegedAction(text));
	}

}
