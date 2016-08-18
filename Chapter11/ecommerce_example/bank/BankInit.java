package ecommerce_example.bank;

import java.rmi.*;
import java.rmi.registry.*;
import java.io.*;
import java.util.*;

/**
  * Start up BankImpl and bind it to the registry.  Takes a command line
	* argument of the properties file to be used
	*/

public class BankInit {
	public static void main( String args[] ) throws Exception {

		if ( args.length != 1 ) {
			usage();
			System.exit( 1 );
		}

		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream( args[ 0 ] );
		properties.load( fis );
		fis.close();

		BankImpl bank = new BankImpl( properties );

		if ( System.getSecurityManager() == null ) {
			System.setSecurityManager( new java.rmi.RMISecurityManager() );
		}
		Naming.rebind("ecommerce_example.Bank", bank);

		// Work-around for bug in RMI over SSL.
		// Need to keep a live thread running.
		while (true) {
			try {
				Thread.sleep(999999);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void usage() {
		System.out.println( "Usage: java\t-Djava.security.policy=BankInit.policy" );
		System.out.println( "\t\t-Djavax.net.ssl.trustStore=TRUST_STORE_FILE" );
		System.out.println( "\t\t-Djavax.net.ssl.keyStore=KEY_STORE_FILE" );
		System.out.println( "\t\t-Djavax.net.ssl.keyStorePassword=KEY_STORE_PASSWORD" );
		System.out.println( "\t\tecommerce_example.BankInit PROPERTIES_FILE" );
	}
}