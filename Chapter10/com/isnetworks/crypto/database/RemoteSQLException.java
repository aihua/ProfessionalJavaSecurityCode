/**
 * @(#) RemoteSQLException.java
 */

package com.isnetworks.crypto.database;

import java.sql.SQLException;
/**
 * This class is mostly for java.rmi.Remote exceptions that are going to 
 * occur because the JDBC implementation is all remote.
 * @author Daniel R. Somerfield
 * @version 1.0
 */

public class RemoteSQLException extends SQLException{
	
	/**
	 * Construct a RemoteSQL exception with a reason.
	 */
    public RemoteSQLException (String reason){
		super(reason);
	}
}
