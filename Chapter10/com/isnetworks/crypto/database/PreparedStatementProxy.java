package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class PreparedStatementProxy extends AbstractProxy implements PreparedStatement {

	private static final Class[] EXECUTE_1 = 
	{java.lang.String.class};

	private static final Class[] EXECUTE_QUERY_1 = 
	{java.lang.String.class};

	private static final Class[] EXECUTE_UPDATE_1 = 
	{java.lang.String.class};

	private static final Class[] ADD_BATCH_1 = 
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

	private static final Class[] SET_TIME_1 = 
	{int.class, java.sql.Time.class, java.util.Calendar.class};

	private static final Class[] SET_TIME_2 = 
	{int.class, java.sql.Time.class};

	private static final Class[] SET_NULL_1 = 
	{int.class, int.class, java.lang.String.class};

	private static final Class[] SET_NULL_2 = 
	{int.class, int.class};

	private static final Class[] SET_BOOLEAN_1 = 
	{int.class, boolean.class};

	private static final Class[] SET_BYTE_1 = 
	{int.class, byte.class};

	private static final Class[] SET_SHORT_1 = 
	{int.class, short.class};

	private static final Class[] SET_INT_1 = 
	{int.class, int.class};

	private static final Class[] SET_LONG_1 = 
	{int.class, long.class};

	private static final Class[] SET_FLOAT_1 = 
	{int.class, float.class};

	private static final Class[] SET_DOUBLE_1 = 
	{int.class, double.class};

	private static final Class[] SET_BIG_DECIMAL_1 = 
	{int.class, java.math.BigDecimal.class};

	private static final Class[] SET_STRING_1 = 
	{int.class, java.lang.String.class};

	private static final Class[] SET_BYTES_1 = 
	{int.class, byte[].class};

	private static final Class[] SET_DATE_1 = 
	{int.class, java.sql.Date.class};

	private static final Class[] SET_DATE_2 = 
	{int.class, java.sql.Date.class, java.util.Calendar.class};

	private static final Class[] SET_TIMESTAMP_1 = 
	{int.class, java.sql.Timestamp.class, java.util.Calendar.class};

	private static final Class[] SET_TIMESTAMP_2 = 
	{int.class, java.sql.Timestamp.class};

	private static final Class[] SET_ASCII_STREAM_1 = 
	{int.class, java.io.InputStream.class, int.class};

	private static final Class[] SET_UNICODE_STREAM_1 = 
	{int.class, java.io.InputStream.class, int.class};

	private static final Class[] SET_BINARY_STREAM_1 = 
	{int.class, java.io.InputStream.class, int.class};

	private static final Class[] SET_OBJECT_1 = 
	{int.class, java.lang.Object.class};

	private static final Class[] SET_OBJECT_2 = 
	{int.class, java.lang.Object.class, int.class, int.class};

	private static final Class[] SET_OBJECT_3 = 
	{int.class, java.lang.Object.class, int.class};

	private static final Class[] SET_CHARACTER_STREAM_1 = 
	{int.class, java.io.Reader.class, int.class};

	private static final Class[] SET_REF_1 = 
	{int.class, java.sql.Ref.class};

	private static final Class[] SET_BLOB_1 = 
	{int.class, java.sql.Blob.class};

	private static final Class[] SET_CLOB_1 = 
	{int.class, java.sql.Clob.class};

	private static final Class[] SET_ARRAY_1 = 
	{int.class, java.sql.Array.class};

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

	public void setTime(int param0, java.sql.Time param1, java.util.Calendar param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			invoke( "setTime", args, SET_TIME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setTime(int param0, java.sql.Time param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setTime", args, SET_TIME_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean execute() throws SQLException {
		try {
			return ((Boolean)invoke( "execute", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet executeQuery() throws SQLException {
		try {
			return (java.sql.ResultSet)invoke( "executeQuery", null, null, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int executeUpdate() throws SQLException {
		try {
			return ((Integer)invoke( "executeUpdate", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setNull(int param0, int param1, java.lang.String param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Integer( param1 );
		args[ 2 ] = param2;

		try {
			invoke( "setNull", args, SET_NULL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setNull(int param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			invoke( "setNull", args, SET_NULL_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setBoolean(int param0, boolean param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Boolean( param1 );

		try {
			invoke( "setBoolean", args, SET_BOOLEAN_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setByte(int param0, byte param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Byte( param1 );

		try {
			invoke( "setByte", args, SET_BYTE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setShort(int param0, short param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Short( param1 );

		try {
			invoke( "setShort", args, SET_SHORT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setInt(int param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			invoke( "setInt", args, SET_INT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setLong(int param0, long param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Long( param1 );

		try {
			invoke( "setLong", args, SET_LONG_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setFloat(int param0, float param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Float( param1 );

		try {
			invoke( "setFloat", args, SET_FLOAT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setDouble(int param0, double param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Double( param1 );

		try {
			invoke( "setDouble", args, SET_DOUBLE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setBigDecimal(int param0, java.math.BigDecimal param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setBigDecimal", args, SET_BIG_DECIMAL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setString(int param0, java.lang.String param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setString", args, SET_STRING_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setBytes(int param0, byte[] param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setBytes", args, SET_BYTES_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setDate(int param0, java.sql.Date param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setDate", args, SET_DATE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setDate(int param0, java.sql.Date param1, java.util.Calendar param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			invoke( "setDate", args, SET_DATE_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setTimestamp(int param0, java.sql.Timestamp param1, java.util.Calendar param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			invoke( "setTimestamp", args, SET_TIMESTAMP_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setTimestamp(int param0, java.sql.Timestamp param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setTimestamp", args, SET_TIMESTAMP_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setAsciiStream(int param0, java.io.InputStream param1, int param2) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void setUnicodeStream(int param0, java.io.InputStream param1, int param2) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void setBinaryStream(int param0, java.io.InputStream param1, int param2) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void clearParameters() throws SQLException {
		try {
			invoke( "clearParameters", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setObject(int param0, java.lang.Object param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setObject", args, SET_OBJECT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setObject(int param0, java.lang.Object param1, int param2, int param3) throws SQLException {
		Object args[] = new Object[ 4 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;
		args[ 2 ] = new Integer( param2 );
		args[ 3 ] = new Integer( param3 );

		try {
			invoke( "setObject", args, SET_OBJECT_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setObject(int param0, java.lang.Object param1, int param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;
		args[ 2 ] = new Integer( param2 );

		try {
			invoke( "setObject", args, SET_OBJECT_3, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void addBatch() throws SQLException {
		try {
			invoke( "addBatch", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setCharacterStream(int param0, java.io.Reader param1, int param2) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void setRef(int param0, java.sql.Ref param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setRef", args, SET_REF_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setBlob(int param0, java.sql.Blob param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setBlob", args, SET_BLOB_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setClob(int param0, java.sql.Clob param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setClob", args, SET_CLOB_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void setArray(int param0, java.sql.Array param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "setArray", args, SET_ARRAY_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSetMetaData getMetaData() throws SQLException {
		try {
			return (java.sql.ResultSetMetaData)invoke( "getMetaData", null, null, com.isnetworks.crypto.database.ResultSetMetaDataProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
