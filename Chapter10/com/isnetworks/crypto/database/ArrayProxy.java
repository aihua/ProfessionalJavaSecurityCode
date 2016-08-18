package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ArrayProxy extends AbstractProxy implements java.sql.Array {

	private static final Class[] GET_ARRAY_1 = 
	{java.util.Map.class};

	private static final Class[] GET_ARRAY_2 = 
	{long.class, int.class};

	private static final Class[] GET_ARRAY_4 = 
	{long.class, int.class, java.util.Map.class};

	private static final Class[] GET_RESULT_SET_1 = 
	{java.util.Map.class};

	private static final Class[] GET_RESULT_SET_2 = 
	{long.class, int.class};

	private static final Class[] GET_RESULT_SET_3 = 
	{long.class, int.class, java.util.Map.class};

	public java.lang.String getBaseTypeName() throws SQLException {
		try {
			return (java.lang.String)invoke( "getBaseTypeName", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getBaseType() throws SQLException {
		try {
			return ((Integer)invoke( "getBaseType", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object getArray(java.util.Map param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.lang.Object)invoke( "getArray", args, GET_ARRAY_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object getArray(long param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Long( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			return (java.lang.Object)invoke( "getArray", args, GET_ARRAY_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object getArray() throws SQLException {
		try {
			return (java.lang.Object)invoke( "getArray", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object getArray(long param0, int param1, java.util.Map param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Long( param0 );
		args[ 1 ] = new Integer( param1 );
		args[ 2 ] = param2;

		try {
			return (java.lang.Object)invoke( "getArray", args, GET_ARRAY_4, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getResultSet(java.util.Map param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.ResultSet)invoke( "getResultSet", args, GET_RESULT_SET_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getResultSet(long param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Long( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			return (java.sql.ResultSet)invoke( "getResultSet", args, GET_RESULT_SET_2, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getResultSet(long param0, int param1, java.util.Map param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Long( param0 );
		args[ 1 ] = new Integer( param1 );
		args[ 2 ] = param2;

		try {
			return (java.sql.ResultSet)invoke( "getResultSet", args, GET_RESULT_SET_3, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getResultSet() throws SQLException {
		try {
			return (java.sql.ResultSet)invoke( "getResultSet", null, null, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
