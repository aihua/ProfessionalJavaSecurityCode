/**
 * @(#) SecureConnectionServer.java
 */

package com.isnetworks.crypto.database;

/**
 * The interface for the root RMI server for the JDBC connections. It 
 * also handles functions such as Authentication, connection configuration...
 * @author Daniel R. Somerfield
 * @version 1.0
 */
import java.sql.*;
import java.rmi.*;
import java.util.Properties;
public interface SecureConnectionServer extends Remote{
    
	public Connection getConnection(Properties props)
		throws RemoteException, SQLException;
}
