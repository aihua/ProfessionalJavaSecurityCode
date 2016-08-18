package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SQLDataProxy extends AbstractProxy implements SQLData {

	private static final Class[] READ_SQL_1 = 
	{java.sql.SQLInput.class, java.lang.String.class};

	private static final Class[] WRITE_SQL_1 = 
	{java.sql.SQLOutput.class};

	public java.lang.String getSQLTypeName() throws SQLException {
		try {
			return (java.lang.String)invoke( "getSQLTypeName", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void readSQL(java.sql.SQLInput param0, java.lang.String param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			invoke( "readSQL", args, READ_SQL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeSQL(java.sql.SQLOutput param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeSQL", args, WRITE_SQL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
