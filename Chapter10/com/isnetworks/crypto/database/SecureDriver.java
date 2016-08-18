/**
 * @(#) SecureDriver.java
 */

package com.isnetworks.crypto.database;

/**
 * Implementation of JDBC Driver that handles encryption and authentication.
 *
 * 
 * The acceptable URL formats are as follows:
 *    jdbc:secureDriver://host[:port]/datasource
 * 
 *       where:
 *          host:port is the location of the server
 *          datasource is the name of the datasource configuration
 *          cert_location is the file system location of the certificate
 *             in the format file:path/to/cert
 *          cert_bytes is the actual bytes of the certicate
 *          username/password is the username and password combo for 
 *             the connection
 *    
 * Note that if the certificate is not included, the driver will attempt to
 * connect with password based authentication. If no certificate or username
 * and password is included, the driver will attempt to connect anonymously
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */

import java.sql.*;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;
import com.isnetworks.util.Debug;

public class SecureDriver implements Driver{
	
	/**
	 * SecureDriver major version
	 */
	private static final int MAJOR_VERSION = 0;

	/**
	 * SecureDriver minor version
	 */
	private static final int MINOR_VERSION = 1;

	/**
	 * Register an instance of the driver when the class loads
	 */
	static {
		try{
			new SecureDriver();
		}catch(SQLException e){
			System.err.println("SecureDriver failed to register");
			e.printStackTrace();	
		}
	}

	/**
	 * Constructor. Regsiter self with the JDBC DriverManager
	 */
	public SecureDriver() throws SQLException{
		DriverManager.registerDriver(this);
	}

	/**
	 * Check if a URL is accepted by this driver
	 * @param url The URL to test
	 * @return true of the driver will accept the url
	 * @exception java.sql.SQLException A database error occured
	 */
	public boolean acceptsURL(String url) throws SQLException {
		if (url.startsWith("jdbc:secureDriver:")){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Return a connection
	 * @param url JDBC connection URL
	 * @param props Connection properties
	 * @return a connection to the server
	 * @exception java.sql.SQLException Indicates a database or network failure
	 */
	public Connection connect(String url, Properties props) 
		throws SQLException {
		
                System.out.println("SecureConnectionServerMain.connect(): " + props);
		//The root RMI object which returns connections
		//Note that this could, for performance reasons, detect if the 
		//connection is within the same VM and then return actual impl
		//objects instead of proxies. This should be cached if possible
		SecureConnectionServer server = null;

		parseURL(url, props);
		
		String host = props.getProperty("host", "localhost");
		String port = props.getProperty("port", "1099");
		String hostPortAndName = "rmi:" + host + ":" + port + "/SecureDriver";
		System.out.println("Trying to connect to: " + hostPortAndName);
		
		try{
			if ( System.getSecurityManager() == null ) {
				System.setSecurityManager( new java.rmi.RMISecurityManager() );
			}
			System.out.println( "Security manager set to " + System.getSecurityManager() );

			server = (SecureConnectionServer)Naming.lookup(hostPortAndName);
		}catch (MalformedURLException e){
			throw new RemoteSQLException("The URL was malformed. Stacktrace:\n"
										 + Debug.getStackTraceAsString(e));
		}catch(NotBoundException e){
			throw new RemoteSQLException("The SecureDriver was not bound " +
										 " to the RMIRegistry." +
										 "StackTrace: \n " + Debug.
										 getStackTraceAsString(e));			
		}catch (AccessException e){
			throw new RemoteSQLException("AccessException: " + 
										 Debug.getStackTraceAsString(e));
		}catch (RemoteException e){
			throw new RemoteSQLException("RemoteException: " +
										 Debug.getStackTraceAsString(e));
		}

		Connection conn = null;
		try{
			conn = server.getConnection(props);
		}catch(RemoteException e){
			throw new RemoteSQLException("RemoteException: " +
										 Debug.getStackTraceAsString(e.detail));
		}

		return conn;
	}
	
	/**
	 * Return the major version number of the SecureDriver
	 * @return SecureDriver major version
	 */
	public int getMajorVersion() {
		return MAJOR_VERSION;
	}
	
	/**
	 * Return the minor version number of the SecureDriver
	 * @return SecureDriver minor version
	 */
	public int getMinorVersion() {
		return MINOR_VERSION;
	}
	
	/**
	 *
	 * @param param1 <description>
	 * @param param2 <description>
	 * @return <description>
	 * @exception java.sql.SQLException <description>
	 */
	public DriverPropertyInfo[] getPropertyInfo
		(String param1, Properties param2) throws SQLException {
		// TODO: implement this java.sql.Driver method
		return null;
	}
	
	/**
	 * Test the driver for JDBC compliance. This will return true
	 * once the JDBC driver compliance test has been passed
	 * @return false
	 */
	public boolean jdbcCompliant() {
		return false;
	}

	/**
	 * Parse the URL and combine it with the properties object
	 */
	private Properties parseURL(String url, Properties props){

		//Parser States:
		//0 Hasn't parsed
		//1 Parsed protocol
		//2 Parsed sub-protocol
		//3 Parsed host

		//Add in parse props here
		StringTokenizer tokenizer = new StringTokenizer(url, ":" );
		String value = null;
		String property = null;
		int state = 0;

		while (tokenizer.hasMoreElements()){
			value = tokenizer.nextToken();
			if (state == 0){
				property = "protocol";
				state = 1;
			}else if (state == 1){
				property = "subprotocol";
				state = 2;
			}else if (state == 2){
				//If the value contains a '/' then it does not include the port
				int slashIndex = value.indexOf('/', 2);
				if (slashIndex==-1){
					//The port was specified
					property="host";
					state = 3;
				}else{
					//The port was not specified
					String host = value.substring(0, slashIndex);
					props.setProperty("host", host);
					value = value.substring(slashIndex+1);
					property="datasource";
				}
			}else if (state == 3){				
				//Port and datasource
				int slashIndex = value.indexOf('/');
				String port = value.substring(0, slashIndex);
				props.setProperty("port", port);
			        value = value.substring(slashIndex+1);
				property = "datasource";				
			}
			props.setProperty(property, value);
		}
		return props;
	}

}
