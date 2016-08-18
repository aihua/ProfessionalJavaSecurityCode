package com.isnetworks.apache.ssl;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.net.*;
import javax.net.ssl.*;

/**
 *	Returns SSL server sockets for use in Tomcat.
 */
public class SSLServerSocketFactoryImpl
	extends org.apache.tomcat.net.ServerSocketFactory {

    private String [] mEnabledSuites;
    private boolean mEnableSessionCreation = true;
    private boolean mNeedClientAuth = false;
    private boolean mUseClientMode = false;

    //Initialize the SecureRandom
    static {
      new java.security.SecureRandom().nextInt();
    }

    public SSLServerSocketFactoryImpl() {
      initProperties();
    }

    private void initProperties() {
      //Enable Suites
      Properties props = System.getProperties();
      Enumeration enum = props.keys();
      String propName;
      Vector suites = new Vector();
      while (enum.hasMoreElements()) {
        propName = (String)enum.nextElement();
        if (propName.startsWith("tomcat.ssl.suites.")) {
          suites.add(props.get(propName));
        }
      }
      mEnabledSuites = new String[suites.size()];
      suites.copyInto(mEnabledSuites);

      //Optionally enable session
      if ("false".equals(System.getProperty
      	("tomcat.ssl.enableSessionCreation"))) {
        mEnableSessionCreation = false;
      }

      //Set client auth
      if ("true".equals(System.getProperty
      	("tomcat.ssl.needClientAuth"))) {
        mNeedClientAuth = true;
      }

      //Set client mode
      if ("true".equals(System.getProperty
      	("tomcat.ssl.useClientMode"))) {
        mUseClientMode = true;
      }
    }


    public ServerSocket createSocket (int port)
    throws IOException {

        SSLServerSocket s = (SSLServerSocket)
        	SSLServerSocketFactory.getDefault().createServerSocket(port);
        setProperties(s);
        return s;

    }

    public ServerSocket createSocket (int port, int backlog)
    throws IOException {

        SSLServerSocket s = (SSLServerSocket)
        	SSLServerSocketFactory.getDefault().createServerSocket(port, backlog);
        setProperties(s);
        return s;
    }

    public ServerSocket createSocket (int port, int backlog,
    InetAddress ifAddress)
    throws IOException {
      SSLServerSocket s = (SSLServerSocket)SSLServerSocketFactory.getDefault().
      createServerSocket(port, backlog, ifAddress);
      setProperties(s);
      return s;
    }

    private void setProperties(SSLServerSocket s) {
      s.setEnableSessionCreation(mEnableSessionCreation);
      s.setNeedClientAuth(mNeedClientAuth);
      s.setUseClientMode(mUseClientMode);
      if (mEnabledSuites.length == 0) {
        System.out.println("Setting all supported suites.");
        s.setEnabledCipherSuites(s.getSupportedCipherSuites());
      } else {
        s.setEnabledCipherSuites(mEnabledSuites);
      }

    }
}