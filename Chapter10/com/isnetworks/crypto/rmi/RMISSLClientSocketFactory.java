package com.isnetworks.crypto.rmi;

import java.io.*;
import java.net.*;
import java.rmi.server.*;
import javax.net.ssl.*;

public class RMISSLClientSocketFactory
implements RMIClientSocketFactory, Serializable {

    public Socket createSocket(String host, int port)
	throws IOException
	{
	    SSLSocketFactory sf = (SSLSocketFactory)SSLSocketFactory.getDefault();
	    SSLSocket socket = (SSLSocket)sf.createSocket(host, port);
	    return socket;
	}
}
