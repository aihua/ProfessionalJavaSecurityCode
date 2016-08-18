package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class StatementProxy extends AbstractProxy implements Statement {

	private static final Class[] EXECUTE_1 = 
	{java.lang.String.class};

	private static final Class[] EXECUTE_QUERY_1 = 
	{java.lang.String.class};

	private static final Class[] EXECUTE_UPDATE_1 = 
	{java.lang.String.class};

	private static final Class[] SET_MAX_FIELD_SIZE_1 = 
	{int.class};

	private static final Class[] SET_MAX_ROWS_1 = 
	{int.class};

	private static final Class[] SET_ESCAPE_PROCESSING_1 = 
	{boolean.class};

	private static final Class[] SET_QUERY_TIMEOUT_1 = 
	{int.class};

	private static final Class[] SET_CURSOR_NAME_1 = 
	{java.lang.String.class};

	private static final Class[] SET_FETCH_DIRECTION_1 = 
	{int.class};

	private static final Class[] SET_FETCH_SIZE_1 = 
	{int.class};

	private static final Class[] ADD_BATCH_1 = 
	{java.lang.String.class};

	public void close() throws SQLException {
		try {
			invoke( "close", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean execute(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Boolean)invoke( "execute", args, EXECUTE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet executeQuery(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.ResultSet)invoke( "executeQuery", args, EXECUTE_QUERY_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int executeUpdate(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Integer)invoke( "executeUpdate", args, EXECUTE_UPDATE_1, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxFieldSize() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxFieldSize", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setMaxFieldSize(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			invoke( "setMaxFieldSize", args, SET_MAX_FIELD_SIZE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxRows() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxRows", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setMaxRows(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			invoke( "setMaxRows", args, SET_MAX_ROWS_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setEscapeProcessing(boolean param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Boolean( param0 );

		try {
			invoke( "setEscapeProcessing", args, SET_ESCAPE_PROCESSING_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getQueryTimeout() throws SQLException {
		try {
			return ((Integer)invoke( "getQueryTimeout", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setQueryTimeout(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			invoke( "setQueryTimeout", args, SET_QUERY_TIMEOUT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void cancel() throws SQLException {
		try {
			invoke( "cancel", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.SQLWarning getWarnings() throws SQLException {
		try {
			return (java.sql.SQLWarning)invoke( "getWarnings", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void clearWarnings() throws SQLException {
		try {
			invoke( "clearWarnings", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setCursorName(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "setCursorName", args, SET_CURSOR_NAME_1, null );
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

	public int getUpdateCount() throws SQLException {
		try {
			return ((Integer)invoke( "getUpdateCount", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean getMoreResults() throws SQLException {
		try {
			return ((Boolean)invoke( "getMoreResults", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setFetchDirection(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			invoke( "setFetchDirection", args, SET_FETCH_DIRECTION_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getFetchDirection() throws SQLException {
		try {
			return ((Integer)invoke( "getFetchDirection", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setFetchSize(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			invoke( "setFetchSize", args, SET_FETCH_SIZE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getFetchSize() throws SQLException {
		try {
			return ((Integer)invoke( "getFetchSize", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getResultSetConcurrency() throws SQLException {
		try {
			return ((Integer)invoke( "getResultSetConcurrency", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getResultSetType() throws SQLException {
		try {
			return ((Integer)invoke( "getResultSetType", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void addBatch(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "addBatch", args, ADD_BATCH_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void clearBatch() throws SQLException {
		try {
			invoke( "clearBatch", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int[] executeBatch() throws SQLException {
		try {
			return (int[])invoke( "executeBatch", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Connection getConnection() throws SQLException {
		try {
			return (java.sql.Connection)invoke( "getConnection", null, null, com.isnetworks.crypto.database.ConnectionProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
