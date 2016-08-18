package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class StructProxy extends AbstractProxy implements Struct {

	private static final Class[] GET_ATTRIBUTES_2 = 
	{java.util.Map.class};

	public java.lang.Object[] getAttributes() throws SQLException {
		try {
			return (java.lang.Object[])invoke( "getAttributes", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object[] getAttributes(java.util.Map param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.lang.Object[])invoke( "getAttributes", args, GET_ATTRIBUTES_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getSQLTypeName() throws SQLException {
		try {
			return (java.lang.String)invoke( "getSQLTypeName", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
