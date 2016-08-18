import java.io.*;
import java.net.*;
import java.rmi.server.*;
import javax.net.ssl.*;

public class RMISSLServerSocketFactory
implements RMIServerSocketFactory, Serializable {

    public ServerSocket createServerSocket(int port)
	throws IOException
	{
	    SSLServerSocketFactory ssf = (SSLServerSocketFactory)
	    	SSLServerSocketFactory.getDefault();
		SSLServerSocket serverSocket = (SSLServerSocket)ssf.createServerSocket(port);
		serverSocket.setNeedClientAuth(true);
		return serverSocket;
	}
}