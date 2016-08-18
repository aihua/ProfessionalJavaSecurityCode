package com.isnetworks.crypto.net;
/*
 * TunnelServer.java
 *
 * Created on April 22, 2000, 2:29 PM
 */
import java.io.*;
import java.net.*;
import java.security.*;
import java.security.cert.*;
import javax.net.*;
import javax.net.ssl.*;
//import com.sun.net.ssl.*;

/**
 * A daemon for accepting tunneled connections over SSL
 * @author  Daniel R. Somerfield
 * @version 1.0
 */
public class TunnelServer {

  /**
   *  The port on which to attach locally
   */
  private int mTunnelPort;

  /**
   * The server to which to connect
   */
  private String mDestServer;

  /**
   * The port of the remote server
   */
  private int mAppPort;


  /**
   * Whether to continue listening or not
   */
  private boolean mListening = true;

  /**
   * Whether or not the service is running as client-server or server-server
   */
  private boolean mRemote;


  /**
   * Creates new TunnelServer
   * @param server the remote server to which to connect
   * @param appPort the port on which the target application us running
   * @param tunnelPort the port on which the SSL connection is to be made
   * @param remote true if this is the remote TunnelServer instance
   * @param keyStore the keystore for the server SSL keys
   */
  public TunnelServer(String server, int appPort, int tunnelPort, boolean remote) {
    super();
    mDestServer = server;
    mAppPort = appPort;
    mTunnelPort = tunnelPort;
    mRemote = remote;
    waitForConnections();
  }

  /**
   * Wait for incoming connections
   */
  private void waitForConnections() {

    ServerSocket serverSocket; //The waiting serverSocket
    Socket srcSocket; //The incoming client Socket
    Socket destSocket; //The destination server Socket
    TunnelThread fromClient;
    TunnelThread toClient;
    serverSocket = getServerSocket();

    while (mListening) {
      try {
        logMessage("Waiting for connections.");
        srcSocket = serverSocket.accept();
        //if this is a local server, make sure it is from localhost
        if (!mRemote && isRemote(srcSocket)) {
          throw new Exception("Illegal access from IP outside localhost");
        }

        logMessage("Connection accepted from " + srcSocket.getInetAddress() +
        ".");
        destSocket = connect();
        logMessage("Connected to remote server at " + destSocket
        .getInetAddress() + ".");
        fromClient = getTunnelThread("fromClient");
        toClient = getTunnelThread("toClient");
        fromClient.setInputStream(srcSocket.getInputStream());
        fromClient.setOutputStream(destSocket.getOutputStream());
        toClient.setInputStream(destSocket.getInputStream());
        toClient.setOutputStream(srcSocket.getOutputStream());
        fromClient.start();
        toClient.start();
      } catch (Exception e) {
        handleException(e);
      }
    }
  }

  /** Is the connector from localhost or not
   * @param clientSocket the socket to check for remote/local
   * @return true if the socket is from a remote machine
   * @throws java.net.UnknownHostException The host to check was not found
   *
   */
  public boolean isRemote(Socket clientSocket) throws UnknownHostException {
    InetAddress localhost = InetAddress.getByName("127.0.0.1");
    System.out.println("Connection from: " + clientSocket.getInetAddress());
    System.out.println("Localhost: " + localhost);
    if (localhost.equals(clientSocket.getInetAddress())) {
      System.out.println("The connection is local");
      return false;
    } else {
      System.out.println("The connection is remote");
      return true;
    }
  }

  /**
   * Create the ServerSocket
   * @returns a custom ServerSocket for SSL connections
   */
  protected ServerSocket getServerSocket() {
    try {
      if (mRemote) {
        //Read in the passphrase
        SSLServerSocketFactory factory = (SSLServerSocketFactory)SSLServerSocketFactory.
          getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket)factory.createServerSocket(mTunnelPort);
        serverSocket.setNeedClientAuth(true);
        return serverSocket;   
      }else {
        return ServerSocketFactory.getDefault().createServerSocket(mAppPort);
      }
    }catch (Exception e) {
      handleException(e);
      mListening = false; //Stop the server
      return null;
    }
  }


  /**
   * Connect to the delegate through SSL or clear
   * @returns a socket to the peer or application
   */
  private Socket connect() throws UnknownHostException, IOException {

    if (mRemote) {
      //Make normal connection
      Socket socket = new Socket(mDestServer, mAppPort);
      return socket;

    } else {
      //Make SSL connection
      SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
      return factory.createSocket(mDestServer, mTunnelPort);
    }
  }

  /**
   * Handle a fatal exception
   * @param e the nasty exception
   */
  private void handleException (Throwable e) {
    System.err.println("A fatal error has occured.");
    e.printStackTrace();
    System.exit(1);
  }

  /**
   * Return a thread, this could be pooled for better performance
   * @param name the name of the thread (for debugging, etc.)
   */
  private TunnelThread getTunnelThread(String name) {
    TunnelThread thread = new TunnelThread(name);
    return thread;
  }

  /**
   * Log a message - currently logs to stdout, but could print to a log file
   * @param message The message to log
   */
  private void logMessage(String message) {
    System.out.println(message);
  }

  /** Main entry point.
   * @param args Command line arguments
   *
   */
  public static void main (String [] args) {

    if (args.length < 4 || !(args[3].equals("local") ||
    args[3].equals("remote"))) {
      usage();
    }

    String destServer = args[0];
    int appPort = Integer.parseInt(args[1]);
    int tunnelPort = Integer.parseInt(args[2]);
    String mode = args[3];

    //Intialize the SecureRandom system
    new SecureRandom().nextBytes(new byte[1]);
    System.out.println("Initialized Random Number generator.");

    TunnelServer server;
    if (mode.equals("local")) {
      server = new TunnelServer(destServer, appPort, tunnelPort, false);
    } else {
      server = new TunnelServer(destServer, appPort, tunnelPort, true);
    }

  }

  private static void usage() {
    System.err.println("usage: java com.isnetworks.crypto.net.TunnelServer " +
    " dest_server app_port tunnel_port [local | remote]");
    System.exit(1);
  }
}
