import java.io.*;
import java.net.*;
import java.security.*;

import javax.net.ssl.*;

import com.sun.net.ssl.*;

/**
 *	SSLSocketServer
 *
 *	This is a demonstration of using SSL over simple
 *	socket communication.
 *
 *	The server opens a server socket on port8080 using SSL,
 *	and waits for a connection. Once a connection is made,
 *	it displays everything sent to the server.
 *
 *	This example uses the com.sun.net.ssl classes to open
 *	a keystore for use by the SSLSockets.
 */
public class SunSSLSocketServer {

	private static final int PORT = 8080;

	public static void main (String[] args) throws Exception {

		// First we need to load a keystore
		char[] passphrase = "sasquatch".toCharArray();
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(new FileInputStream(".keystore"), passphrase);

		// Now we initialize a KeyManagerFactory with the KeyStore
		KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		kmf.init(keystore, passphrase);

		// Now we create an SSLContext and initialize it with
		// KeyManagers from the KeyManagerFactory
		SSLContext context = SSLContext.getInstance("TLS");
		KeyManager[] keyManagers = kmf.getKeyManagers();

		context.init(keyManagers, null, null);

		// First we need a SocketFactory that will create
		// SSL server sockets.
		SSLServerSocketFactory ssf = context.getServerSocketFactory();
		ServerSocket ss = ssf.createServerSocket(PORT);

		// Wait for a connection
		Socket s = ss.accept();

		// Get the input stream. These will be
		// encrypted transparently.
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

		// Read through the input from the client,
		// and display it to the screen.
		String line = null;
		while (((line = in.readLine())!= null)) {
			System.out.println(line);
		}
		in.close();
		s.close();
	}
}