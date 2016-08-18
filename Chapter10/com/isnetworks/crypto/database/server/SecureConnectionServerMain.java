/**
 * @(#) SecureConnectionServerMain.java
 */

package com.isnetworks.crypto.database.server;
/**
 * The main entry point for the secure connection server.
 * @author Daniel R. Somerfield
 * @version 1.0
 */
import java.io.*;
import java.rmi.*;
import com.isnetworks.util.*;
import com.isnetworks.crypto.database.*;
import com.isnetworks.crypto.rmi.*;
public class SecureConnectionServerMain {

  private static final String DEFAULT_BIND_NAME= "SecureDriver";

  private static XMLProperties mProps;

  /**
   * Entry point. Start up the server process and export the remote
   * objects
   */
  public static void main( String [] args ){

    String bindName = null;

    //Add argument parsing function
    if (args.length < 1){
      usage();
      System.exit(1);
    }

    String fileName = args[0];

    //Parse the xml config file
    DatasourceManager manager = null;
    try{
      mProps = new XMLProperties();
      mProps.load(new FileInputStream(args[0]));

      //Send the root node of the datasources to the datasource pool
      XMLProperties dataSources = (XMLProperties)mProps.getProperty
        ("dataSources").iterator().next();

      manager = new SimpleDatasourceManager(dataSources);

      //Pull the server name and bind

      bindName = (String)mProps.getProperty("id").iterator().next();
      if (bindName == null){
        bindName = DEFAULT_BIND_NAME;
      }

    }catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }

    try{
      System.out.println("Registering SecureDriver as " +
      bindName + ".");

      SecureConnectionServerImpl connectionServer = new SecureConnectionServerImpl( manager, 0, new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory() );
			if ( System.getSecurityManager() == null ) {
				System.setSecurityManager( new java.rmi.RMISecurityManager() );
			}
			Naming.rebind(bindName, connectionServer);
      System.out.println(bindName + " registered.");
    }catch(Exception e){
      e.printStackTrace();
      System.exit(1);
    }

	// SSL-RMI bug work-around
	while (true) {
		try{

			Thread.sleep( Long.MAX_VALUE );
		}
		catch( InterruptedException e ){
		}
	}

  }

  private static void usage(){
    System.err.println("usage: java com.isnetworks.crypto.database.server.SecureConnectionServerMain config_file");
  }

}
