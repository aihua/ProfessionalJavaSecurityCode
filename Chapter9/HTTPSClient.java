import java.io.*;
import java.net.*;

/**
 *	HTTPSClient
 *
 *	This class fetches an HTTPS url to illustrate
 *	the use of HTTPS on the client. It requests
 *	a URL and prints its content to standard out.
 *
 *	If an argument is passed, it will use it as the URL
 *	to connect to. Example:
 *
 *	java HTTPSClient https://www.verisign.com
 *
 */
public class HTTPSClient {

	public static void main (String[] args) throws Exception {

		/**	Begin by setting the URL handler so that it
		 * 	will find the HTTPS classes.
		 *	This could also be done by setting the property
		 *	at runtime with:
		 *
		 *	java -Djava.protocol.handler.pkgs=com.sun.net.ssl.internal.www.protocol
		 */
		System.setProperty("java.protocol.handler.pkgs",
			"com.sun.net.ssl.internal.www.protocol");

		// Here's the default URL
		String urlString = "https://www.verisign.com/";

		// If an argument has been passed, use it
		// as the url to attach to.
		if (args.length > 0) {
			urlString = args[0];
		}

		URL url = new URL(urlString);
		BufferedReader in = new BufferedReader(
			new InputStreamReader(url.openStream()));

		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		in.close();
	}
}
