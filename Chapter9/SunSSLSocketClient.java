import java.io.*;
import java.net.*;
import java.security.*;

import javax.net.ssl.*;

import com.sun.net.ssl.*;

/**
 *	SSLSocketClient
 *
 *	This is a demonstration of using SSL over simple
 *	socket communication.
 *
 *	The client opens a connection to localhost:8080 using SSL,
 *	and then sends each character typed to the other end,
 *	encrypted through SSL.
 *
 *	This example uses the com.sun.net.ssl classes to avoid
 *	having to pass keystore information on the command-line.
 */
public class SunSSLSocketClient {

	private static final String HOST = "localhost";
	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {

		// First we need to load a keystore
		char[] passphrase = "sasquatch".toCharArray();
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(new FileInputStream(".keystore"), passphrase);

		// Now we initialize a TrustManagerFactory with the KeyStore
		TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
		tmf.init(keystore);

		// Now we create an SSLContext and initialize it with
		// TrustManagers from the TrustManagerFactory
		SSLContext context = SSLContext.getInstance("TLS");
		TrustManager[] trustManagers = tmf.getTrustManagers();

		context.init(null, trustManagers, null);

		// First we need a SocketFactory that will create
		// SSL sockets.
		SSLSocketFactory sf = context.getSocketFactory();

		// Open a connection
		Socket s = sf.createSocket(HOST,PORT);

		// Get the input and output streams. These will be
		// encrypted transparently.
		OutputStream out = s.getOutputStream();
		out.write("\nConnection established.\n\n".getBytes());
		System.out.print("\nConnection established.\n\n");

		// Now send everything the user types
		int theCharacter=0;
		theCharacter = System.in.read();
		while (theCharacter != '~') // The '~' is an escape character to exit
		{
		  out.write(theCharacter);
		  out.flush();
		  theCharacter = System.in.read();
		}

		out.close();
		s.close();
	}
}

