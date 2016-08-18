import java.io.*;
import java.net.*;
import javax.net.ssl.*;

/**
 *	HTTPSServer
 *
 *	A very simple HTTPS Server, using the JSSE.
 *	It returns a success message over HTTPS.
 *
 *	This version has been altered to require client authentication.
 *
 *	In order to run this example, you will need to set the
 *	following System properties on the command-line:
 *
 *	javax.net.ssl.keyStore
 *	javax.net.ssl.keyStorePassword
 *	javax.net.ssl.trustStore
 *	javax.net.ssl.trustStorePassword
 *
 *	Here's an example (enter all on one line):
 *
 *	java -Djavax.net.ssl.keyStore=.keystore
 *	  -Djavax.net.ssl.keyStorePassword=password
 *	  -Djavax.net.ssl.trustStore=.truststore
 *	  -Djavax.net.ssl.trustStorePassword=password
 *	  HTTPSServer
 *
 */
public class HTTPSServerWithAuth {

	public static void main(String[] args) throws IOException {

		// First we need a SocketFactory that will create
		// SSL server sockets.
		SSLServerSocketFactory ssf = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
		SSLServerSocket ss = (SSLServerSocket)ssf.createServerSocket(8080);

		// Require client authentication
		ss.setNeedClientAuth(true);

		// Keep on accepting connections forever
		while (true) {
			try {
				Socket s = ss.accept();

				// Get the input and output streams. These will be
				// encrypted transparently.
				OutputStream out = s.getOutputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

				// Read through the input from the client,
				// and display it to the screen.
				String line = null;
				while (((line = in.readLine())!= null) && (!("".equals(line)))) {
					System.out.println(line);
				}
				System.out.println("");

				// Construct a response
				StringBuffer buffer = new StringBuffer();
				buffer.append("<HTML>\n");
				buffer.append("<HEAD><TITLE>HTTPS Server</TITLE></HEAD>\n");
				buffer.append("<BODY>\n");
				buffer.append("<H1>Success!</H1>\n");
				buffer.append("</BODY>\n");
				buffer.append("</HTML>\n");

				// HTTP requires a content-length.
				String string = buffer.toString();
				byte[] data = string.getBytes();
				out.write("HTTP/1.0 200 OK\n".getBytes());
				out.write(new String("Content-Length: "+data.length+"\n").getBytes());
				out.write("Content-Type: text/html\n\n".getBytes());
				out.write(data);
				out.flush();

				// Close the streams and socket.
				out.close();
				in.close();
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}



