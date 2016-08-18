package com.isnetworks.crypto.net;
/*
 * TunnelThread.java
 *
 * Created on April 22, 2000, 3:36 PM
 */
import java.io.*;
/**
 * Handles the actual SSL tunelling between client and server
 * @author  Daniel R. Somerfield
 * @version 1.0
 */
public class TunnelThread extends Thread {

  /**
   * The source of incoming bytes
   */
  private InputStream mIn;

  /**
   * The stream to write outgoing bytes
   */
  private OutputStream mOut;

  /**
   * Creates new TunnelThread
   * @param name a name for this thread
   */
  public TunnelThread(String name) {
    super(name);
    setDaemon(true);
  }
  
  /**
  * Default constructor -- create a tunnel thread with a default name
  */
  public TunnelThread() {
    super();
    setDaemon(true);
  }

  /**
   * Set the source of the bytes
   * @param in the source InputStream
   */
  public void setInputStream(InputStream in) {
    mIn = in;
  }

  /**
   * Set the destination stream
   * @param out the destination OuputStream
   */
  public void setOutputStream(OutputStream out) {
    mOut = out;
  }

  /**
   * Read from the InputStream and write to the OutputStream until EOF or exception
   */
  public void run() {
    log("Starting tunnel");
    try {
      int i;
      while ((i = mIn.read()) != -1) {
        mOut.write(i);
        mOut.flush();
      }

      mIn.close();
      mOut.close();
    } catch (IOException e) {
        //We can't really do anything with this. Most likely, the connection
        //has been disconnected. So just exit.
    }

    log("Tunneling complete");

  }

  /**
  * Log a message -- currently this only writes to standard out, 
  * but it should probably log to a non-blocking output stream
  * @param msg The message to log
  */
  public void log(String msg) {
    System.out.println(getName() + ": " + msg);
  }

}
