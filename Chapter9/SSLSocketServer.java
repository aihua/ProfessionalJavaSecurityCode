import java.io.*;
import java.net.*;
import javax.net.ssl.*;

/**
 *	SSLSocketServer
 *
 *	This is a demonstration of using SSL over simple
 *	socket communication.
 *
 *	The server opens a server socket on port8080 using SSL,
 *	and waits for a connection. Once a connection is made,
 *	it displays everything sent to the server.
 */
public class SSLSocketServer {

	private static final int PORT = 8080;

	public static void main (String[] args) throws Exception {

		// First we need a SocketFactory that will create
		// SSL server sockets.
		SSLServerSocketFactory ssf = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
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