import java.io.*;
import java.net.*;
import javax.net.ssl.*;

/**
 *	SSLSocketClient
 *
 *	This is a demonstration of using SSL over simple
 *	socket communication.
 *
 *	The client opens a connection to localhost:8080 using SSL,
 *	and then sends each character typed to the other end,
 *	encrypted through SSL.
 */
public class SSLSocketClient {

	private static final String HOST = "localhost";
	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {

		// First we need a SocketFactory that will create
		// SSL  sockets.
		SSLSocketFactory sf = (SSLSocketFactory)SSLSocketFactory.getDefault();
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

