/**
 * @(#) SecureConnectionServerImpl.java
 */

package com.isnetworks.crypto.database.server;

/**
 * Implementation of SecureConnectionServer.
 * @author Daniel R. Somerfield
 * @version 1.0
 */
import java.rmi.*;
import java.rmi.server.*;
import java.util.Properties;
import java.sql.*;
import com.isnetworks.remote.proxy.*;
import com.isnetworks.crypto.database.*;
public class SecureConnectionServerImpl extends UnicastRemoteObject 
	implements SecureConnectionServer{

	/**
	 * The manager responsible for different datasources
	 */
	private DatasourceManager mDatasourceManager;

	public SecureConnectionServerImpl(DatasourceManager datasourceManager )
		throws RemoteException{
		mDatasourceManager = datasourceManager;
	}

	public SecureConnectionServerImpl( DatasourceManager datasourceManager,
	                                   int port,
	                                   RMIClientSocketFactory clientFactory,
	                                   RMIServerSocketFactory serverFactory )
		throws RemoteException{
		
		super( port, clientFactory, serverFactory );
		mDatasourceManager = datasourceManager;
	}	

	/**
	 * Lookup the correct datasource, delegate a security check, then
	 * delegate the creation of the connection
	 */
	public Connection getConnection(Properties props)
		throws RemoteException, SQLException{

		String dataSource = props.getProperty("datasource");
		String username = props.getProperty("user");
		String password = props.getProperty("password");
		if (dataSource == null){
			throw new SQLException("No datasource was a specified.");
		}
		
		//Assuming everything works, return a ConnectionProxy wrapping a real
		//connection
		Connection conn = getConnection(dataSource, username, password);
		
		OperationProxy impl =  new OperationProxyImpl(conn);
		
		ConnectionProxy proxy = new ConnectionProxy();	
		proxy.setOperationProxy( impl );
		return proxy;
	}

	/**
	 * Return a REAL database connection
	 */
	protected Connection getConnection(String dataSource, String username, 
									   String password)
		throws SQLException{

		return mDatasourceManager.getConnection(dataSource, username, password);

	}
    
}


