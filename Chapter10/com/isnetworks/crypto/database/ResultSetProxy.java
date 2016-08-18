package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ResultSetProxy extends AbstractProxy implements ResultSet {

	private static final Class[] GET_BYTES_1 = 
	{java.lang.String.class};

	private static final Class[] GET_BYTES_2 = 
	{int.class};

	private static final Class[] GET_BOOLEAN_1 = 
	{int.class};

	private static final Class[] GET_BOOLEAN_2 = 
	{java.lang.String.class};

	private static final Class[] GET_LONG_1 = 
	{int.class};

	private static final Class[] GET_LONG_2 = 
	{java.lang.String.class};

	private static final Class[] GET_OBJECT_1 = 
	{java.lang.String.class, java.util.Map.class};

	private static final Class[] GET_OBJECT_2 = 
	{int.class};

	private static final Class[] GET_OBJECT_3 = 
	{java.lang.String.class};

	private static final Class[] GET_OBJECT_4 = 
	{int.class, java.util.Map.class};

	private static final Class[] GET_REF_1 = 
	{java.lang.String.class};

	private static final Class[] GET_REF_2 = 
	{int.class};

	private static final Class[] GET_TIME_1 = 
	{int.class, java.util.Calendar.class};

	private static final Class[] GET_TIME_2 = 
	{java.lang.String.class, java.util.Calendar.class};

	private static final Class[] GET_TIME_3 = 
	{java.lang.String.class};

	private static final Class[] GET_TIME_4 = 
	{int.class};

	private static final Class[] GET_DATE_1 = 
	{int.class};

	private static final Class[] GET_DATE_2 = 
	{java.lang.String.class, java.util.Calendar.class};

	private static final Class[] GET_DATE_3 = 
	{java.lang.String.class};

	private static final Class[] GET_DATE_4 = 
	{int.class, java.util.Calendar.class};

	private static final Class[] GET_STRING_1 = 
	{java.lang.String.class};

	private static final Class[] GET_STRING_2 = 
	{int.class};

	private static final Class[] GET_BYTE_1 = 
	{java.lang.String.class};

	private static final Class[] GET_BYTE_2 = 
	{int.class};

	private static final Class[] GET_SHORT_1 = 
	{java.lang.String.class};

	private static final Class[] GET_SHORT_2 = 
	{int.class};

	private static final Class[] GET_INT_1 = 
	{int.class};

	private static final Class[] GET_INT_2 = 
	{java.lang.String.class};

	private static final Class[] GET_FLOAT_1 = 
	{java.lang.String.class};

	private static final Class[] GET_FLOAT_2 = 
	{int.class};

	private static final Class[] GET_DOUBLE_1 = 
	{int.class};

	private static final Class[] GET_DOUBLE_2 = 
	{java.lang.String.class};

	private static final Class[] GET_BIG_DECIMAL_1 = 
	{java.lang.String.class};

	private static final Class[] GET_BIG_DECIMAL_2 = 
	{int.class};

	private static final Class[] GET_BIG_DECIMAL_3 = 
	{int.class, int.class};

	private static final Class[] GET_BIG_DECIMAL_4 = 
	{java.lang.String.class, int.class};

	private static final Class[] GET_TIMESTAMP_1 = 
	{java.lang.String.class};

	private static final Class[] GET_TIMESTAMP_2 = 
	{java.lang.String.class, java.util.Calendar.class};

	private static final Class[] GET_TIMESTAMP_3 = 
	{int.class};

	private static final Class[] GET_TIMESTAMP_4 = 
	{int.class, java.util.Calendar.class};

	private static final Class[] GET_ASCII_STREAM_1 = 
	{java.lang.String.class};

	private static final Class[] GET_ASCII_STREAM_2 = 
	{int.class};

	private static final Class[] GET_UNICODE_STREAM_1 = 
	{int.class};

	private static final Class[] GET_UNICODE_STREAM_2 = 
	{java.lang.String.class};

	private static final Class[] GET_BINARY_STREAM_1 = 
	{int.class};

	private static final Class[] GET_BINARY_STREAM_2 = 
	{java.lang.String.class};

	private static final Class[] FIND_COLUMN_1 = 
	{java.lang.String.class};

	private static final Class[] GET_CHARACTER_STREAM_1 = 
	{java.lang.String.class};

	private static final Class[] GET_CHARACTER_STREAM_2 = 
	{int.class};

	private static final Class[] ABSOLUTE_1 = 
	{int.class};

	private static final Class[] RELATIVE_1 = 
	{int.class};

	private static final Class[] SET_FETCH_DIRECTION_1 = 
	{int.class};

	private static final Class[] SET_FETCH_SIZE_1 = 
	{int.class};

	private static final Class[] UPDATE_NULL_1 = 
	{int.class};

	private static final Class[] UPDATE_NULL_2 = 
	{java.lang.String.class};

	private static final Class[] UPDATE_BOOLEAN_1 = 
	{int.class, boolean.class};

	private static final Class[] UPDATE_BOOLEAN_2 = 
	{java.lang.String.class, boolean.class};

	private static final Class[] UPDATE_BYTE_1 = 
	{java.lang.String.class, byte.class};

	private static final Class[] UPDATE_BYTE_2 = 
	{int.class, byte.class};

	private static final Class[] UPDATE_SHORT_1 = 
	{int.class, short.class};

	private static final Class[] UPDATE_SHORT_2 = 
	{java.lang.String.class, short.class};

	private static final Class[] UPDATE_INT_1 = 
	{int.class, int.class};

	private static final Class[] UPDATE_INT_2 = 
	{java.lang.String.class, int.class};

	private static final Class[] UPDATE_LONG_1 = 
	{int.class, long.class};

	private static final Class[] UPDATE_LONG_2 = 
	{java.lang.String.class, long.class};

	private static final Class[] UPDATE_FLOAT_1 = 
	{java.lang.String.class, float.class};

	private static final Class[] UPDATE_FLOAT_2 = 
	{int.class, float.class};

	private static final Class[] UPDATE_DOUBLE_1 = 
	{int.class, double.class};

	private static final Class[] UPDATE_DOUBLE_2 = 
	{java.lang.String.class, double.class};

	private static final Class[] UPDATE_BIG_DECIMAL_1 = 
	{java.lang.String.class, java.math.BigDecimal.class};

	private static final Class[] UPDATE_BIG_DECIMAL_2 = 
	{int.class, java.math.BigDecimal.class};

	private static final Class[] UPDATE_STRING_1 = 
	{java.lang.String.class, java.lang.String.class};

	private static final Class[] UPDATE_STRING_2 = 
	{int.class, java.lang.String.class};

	private static final Class[] UPDATE_BYTES_1 = 
	{int.class, byte[].class};

	private static final Class[] UPDATE_BYTES_2 = 
	{java.lang.String.class, byte[].class};

	private static final Class[] UPDATE_DATE_1 = 
	{int.class, java.sql.Date.class};

	private static final Class[] UPDATE_DATE_2 = 
	{java.lang.String.class, java.sql.Date.class};

	private static final Class[] UPDATE_TIME_1 = 
	{java.lang.String.class, java.sql.Time.class};

	private static final Class[] UPDATE_TIME_2 = 
	{int.class, java.sql.Time.class};

	private static final Class[] UPDATE_TIMESTAMP_1 = 
	{int.class, java.sql.Timestamp.class};

	private static final Class[] UPDATE_TIMESTAMP_2 = 
	{java.lang.String.class, java.sql.Timestamp.class};

	private static final Class[] UPDATE_ASCII_STREAM_1 = 
	{int.class, java.io.InputStream.class, int.class};

	private static final Class[] UPDATE_ASCII_STREAM_2 = 
	{java.lang.String.class, java.io.InputStream.class, int.class};

	private static final Class[] UPDATE_BINARY_STREAM_1 = 
	{int.class, java.io.InputStream.class, int.class};

	private static final Class[] UPDATE_BINARY_STREAM_2 = 
	{java.lang.String.class, java.io.InputStream.class, int.class};

	private static final Class[] UPDATE_CHARACTER_STREAM_1 = 
	{int.class, java.io.Reader.class, int.class};

	private static final Class[] UPDATE_CHARACTER_STREAM_2 = 
	{java.lang.String.class, java.io.Reader.class, int.class};

	private static final Class[] UPDATE_OBJECT_1 = 
	{int.class, java.lang.Object.class};

	private static final Class[] UPDATE_OBJECT_2 = 
	{int.class, java.lang.Object.class, int.class};

	private static final Class[] UPDATE_OBJECT_3 = 
	{java.lang.String.class, java.lang.Object.class};

	private static final Class[] UPDATE_OBJECT_4 = 
	{java.lang.String.class, java.lang.Object.class, int.class};

	private static final Class[] GET_BLOB_1 = 
	{int.class};

	private static final Class[] GET_BLOB_2 = 
	{java.lang.String.class};

	private static final Class[] GET_CLOB_1 = 
	{java.lang.String.class};

	private static final Class[] GET_CLOB_2 = 
	{int.class};

	private static final Class[] GET_ARRAY_1 = 
	{int.class};

	private static final Class[] GET_ARRAY_2 = 
	{java.lang.String.class};

	public byte[] getBytes(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (byte[])invoke( "getBytes", args, GET_BYTES_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public byte[] getBytes(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (byte[])invoke( "getBytes", args, GET_BYTES_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean next() throws SQLException {
		try {
			return ((Boolean)invoke( "next", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean getBoolean(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "getBoolean", args, GET_BOOLEAN_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean getBoolean(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Boolean)invoke( "getBoolean", args, GET_BOOLEAN_2, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getType() throws SQLException {
		try {
			return ((Integer)invoke( "getType", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public long getLong(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Long)invoke( "getLong", args, GET_LONG_1, null )).longValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public long getLong(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Long)invoke( "getLong", args, GET_LONG_2, null )).longValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean previous() throws SQLException {
		try {
			return ((Boolean)invoke( "previous", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void close() throws SQLException {
		try {
			invoke( "close", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object getObject(java.lang.String param0, java.util.Map param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			return (java.lang.Object)invoke( "getObject", args, GET_OBJECT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object getObject(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.Object)invoke( "getObject", args, GET_OBJECT_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object getObject(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.lang.Object)invoke( "getObject", args, GET_OBJECT_3, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.Object getObject(int param0, java.util.Map param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			return (java.lang.Object)invoke( "getObject", args, GET_OBJECT_4, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Ref getRef(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.Ref)invoke( "getRef", args, GET_REF_1, com.isnetworks.crypto.database.RefProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Ref getRef(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.sql.Ref)invoke( "getRef", args, GET_REF_2, com.isnetworks.crypto.database.RefProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Time getTime(int param0, java.util.Calendar param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			return (java.sql.Time)invoke( "getTime", args, GET_TIME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Time getTime(java.lang.String param0, java.util.Calendar param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			return (java.sql.Time)invoke( "getTime", args, GET_TIME_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Time getTime(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.Time)invoke( "getTime", args, GET_TIME_3, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Time getTime(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.sql.Time)invoke( "getTime", args, GET_TIME_4, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Date getDate(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.sql.Date)invoke( "getDate", args, GET_DATE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Date getDate(java.lang.String param0, java.util.Calendar param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			return (java.sql.Date)invoke( "getDate", args, GET_DATE_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Date getDate(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.Date)invoke( "getDate", args, GET_DATE_3, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Date getDate(int param0, java.util.Calendar param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			return (java.sql.Date)invoke( "getDate", args, GET_DATE_4, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean wasNull() throws SQLException {
		try {
			return ((Boolean)invoke( "wasNull", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getString(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.lang.String)invoke( "getString", args, GET_STRING_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getString(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.String)invoke( "getString", args, GET_STRING_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public byte getByte(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Byte)invoke( "getByte", args, GET_BYTE_1, null )).byteValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public byte getByte(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Byte)invoke( "getByte", args, GET_BYTE_2, null )).byteValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public short getShort(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Short)invoke( "getShort", args, GET_SHORT_1, null )).shortValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public short getShort(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Short)invoke( "getShort", args, GET_SHORT_2, null )).shortValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getInt(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Integer)invoke( "getInt", args, GET_INT_1, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getInt(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Integer)invoke( "getInt", args, GET_INT_2, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public float getFloat(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Float)invoke( "getFloat", args, GET_FLOAT_1, null )).floatValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public float getFloat(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Float)invoke( "getFloat", args, GET_FLOAT_2, null )).floatValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public double getDouble(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Double)invoke( "getDouble", args, GET_DOUBLE_1, null )).doubleValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public double getDouble(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Double)invoke( "getDouble", args, GET_DOUBLE_2, null )).doubleValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.math.BigDecimal getBigDecimal(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.math.BigDecimal)invoke( "getBigDecimal", args, GET_BIG_DECIMAL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.math.BigDecimal getBigDecimal(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.math.BigDecimal)invoke( "getBigDecimal", args, GET_BIG_DECIMAL_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.math.BigDecimal getBigDecimal(int param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			return (java.math.BigDecimal)invoke( "getBigDecimal", args, GET_BIG_DECIMAL_3, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.math.BigDecimal getBigDecimal(java.lang.String param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Integer( param1 );

		try {
			return (java.math.BigDecimal)invoke( "getBigDecimal", args, GET_BIG_DECIMAL_4, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Timestamp getTimestamp(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.Timestamp)invoke( "getTimestamp", args, GET_TIMESTAMP_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Timestamp getTimestamp(java.lang.String param0, java.util.Calendar param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			return (java.sql.Timestamp)invoke( "getTimestamp", args, GET_TIMESTAMP_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Timestamp getTimestamp(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.sql.Timestamp)invoke( "getTimestamp", args, GET_TIMESTAMP_3, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Timestamp getTimestamp(int param0, java.util.Calendar param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			return (java.sql.Timestamp)invoke( "getTimestamp", args, GET_TIMESTAMP_4, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.InputStream getAsciiStream(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.io.InputStream)invoke( "getAsciiStream", args, GET_ASCII_STREAM_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.InputStream getAsciiStream(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.io.InputStream)invoke( "getAsciiStream", args, GET_ASCII_STREAM_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.InputStream getUnicodeStream(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.io.InputStream)invoke( "getUnicodeStream", args, GET_UNICODE_STREAM_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.InputStream getUnicodeStream(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.io.InputStream)invoke( "getUnicodeStream", args, GET_UNICODE_STREAM_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.InputStream getBinaryStream(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.io.InputStream)invoke( "getBinaryStream", args, GET_BINARY_STREAM_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.InputStream getBinaryStream(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.io.InputStream)invoke( "getBinaryStream", args, GET_BINARY_STREAM_2, null );
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

	public java.lang.String getCursorName() throws SQLException {
		try {
			return (java.lang.String)invoke( "getCursorName", null, null, null );
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

	public int findColumn(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return ((Integer)invoke( "findColumn", args, FIND_COLUMN_1, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.Reader getCharacterStream(java.lang.String param0) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public java.io.Reader getCharacterStream(int param0) throws SQLException {
	            throw new UnsupportedOperationException("Not implemented.");
	}

	public boolean isBeforeFirst() throws SQLException {
		try {
			return ((Boolean)invoke( "isBeforeFirst", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isAfterLast() throws SQLException {
		try {
			return ((Boolean)invoke( "isAfterLast", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isFirst() throws SQLException {
		try {
			return ((Boolean)invoke( "isFirst", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isLast() throws SQLException {
		try {
			return ((Boolean)invoke( "isLast", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void beforeFirst() throws SQLException {
		try {
			invoke( "beforeFirst", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void afterLast() throws SQLException {
		try {
			invoke( "afterLast", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean first() throws SQLException {
		try {
			return ((Boolean)invoke( "first", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean last() throws SQLException {
		try {
			return ((Boolean)invoke( "last", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getRow() throws SQLException {
		try {
			return ((Integer)invoke( "getRow", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean absolute(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "absolute", args, ABSOLUTE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean relative(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "relative", args, RELATIVE_1, null )).booleanValue();
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

	public int getConcurrency() throws SQLException {
		try {
			return ((Integer)invoke( "getConcurrency", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean rowUpdated() throws SQLException {
		try {
			return ((Boolean)invoke( "rowUpdated", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean rowInserted() throws SQLException {
		try {
			return ((Boolean)invoke( "rowInserted", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean rowDeleted() throws SQLException {
		try {
			return ((Boolean)invoke( "rowDeleted", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateNull(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			invoke( "updateNull", args, UPDATE_NULL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateNull(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "updateNull", args, UPDATE_NULL_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateBoolean(int param0, boolean param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Boolean( param1 );

		try {
			invoke( "updateBoolean", args, UPDATE_BOOLEAN_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateBoolean(java.lang.String param0, boolean param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Boolean( param1 );

		try {
			invoke( "updateBoolean", args, UPDATE_BOOLEAN_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateByte(java.lang.String param0, byte param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Byte( param1 );

		try {
			invoke( "updateByte", args, UPDATE_BYTE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateByte(int param0, byte param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Byte( param1 );

		try {
			invoke( "updateByte", args, UPDATE_BYTE_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateShort(int param0, short param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Short( param1 );

		try {
			invoke( "updateShort", args, UPDATE_SHORT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateShort(java.lang.String param0, short param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Short( param1 );

		try {
			invoke( "updateShort", args, UPDATE_SHORT_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateInt(int param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			invoke( "updateInt", args, UPDATE_INT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateInt(java.lang.String param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Integer( param1 );

		try {
			invoke( "updateInt", args, UPDATE_INT_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateLong(int param0, long param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Long( param1 );

		try {
			invoke( "updateLong", args, UPDATE_LONG_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateLong(java.lang.String param0, long param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Long( param1 );

		try {
			invoke( "updateLong", args, UPDATE_LONG_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateFloat(java.lang.String param0, float param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Float( param1 );

		try {
			invoke( "updateFloat", args, UPDATE_FLOAT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateFloat(int param0, float param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Float( param1 );

		try {
			invoke( "updateFloat", args, UPDATE_FLOAT_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateDouble(int param0, double param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Double( param1 );

		try {
			invoke( "updateDouble", args, UPDATE_DOUBLE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateDouble(java.lang.String param0, double param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Double( param1 );

		try {
			invoke( "updateDouble", args, UPDATE_DOUBLE_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateBigDecimal(java.lang.String param0, java.math.BigDecimal param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			invoke( "updateBigDecimal", args, UPDATE_BIG_DECIMAL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateBigDecimal(int param0, java.math.BigDecimal param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "updateBigDecimal", args, UPDATE_BIG_DECIMAL_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateString(java.lang.String param0, java.lang.String param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			invoke( "updateString", args, UPDATE_STRING_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateString(int param0, java.lang.String param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "updateString", args, UPDATE_STRING_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateBytes(int param0, byte[] param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "updateBytes", args, UPDATE_BYTES_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateBytes(java.lang.String param0, byte[] param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			invoke( "updateBytes", args, UPDATE_BYTES_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateDate(int param0, java.sql.Date param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "updateDate", args, UPDATE_DATE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateDate(java.lang.String param0, java.sql.Date param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			invoke( "updateDate", args, UPDATE_DATE_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateTime(java.lang.String param0, java.sql.Time param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			invoke( "updateTime", args, UPDATE_TIME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateTime(int param0, java.sql.Time param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "updateTime", args, UPDATE_TIME_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateTimestamp(int param0, java.sql.Timestamp param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "updateTimestamp", args, UPDATE_TIMESTAMP_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateTimestamp(java.lang.String param0, java.sql.Timestamp param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			invoke( "updateTimestamp", args, UPDATE_TIMESTAMP_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateAsciiStream(int param0, java.io.InputStream param1, int param2) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void updateAsciiStream(java.lang.String param0, java.io.InputStream param1, int param2) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void updateBinaryStream(int param0, java.io.InputStream param1, int param2) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void updateBinaryStream(java.lang.String param0, java.io.InputStream param1, int param2) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void updateCharacterStream(int param0, java.io.Reader param1, int param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;
		args[ 2 ] = new Integer( param2 );

		try {
			invoke( "updateCharacterStream", args, UPDATE_CHARACTER_STREAM_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateCharacterStream(java.lang.String param0, java.io.Reader param1, int param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = new Integer( param2 );

		try {
			invoke( "updateCharacterStream", args, UPDATE_CHARACTER_STREAM_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateObject(int param0, java.lang.Object param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;

		try {
			invoke( "updateObject", args, UPDATE_OBJECT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateObject(int param0, java.lang.Object param1, int param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = param1;
		args[ 2 ] = new Integer( param2 );

		try {
			invoke( "updateObject", args, UPDATE_OBJECT_2, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateObject(java.lang.String param0, java.lang.Object param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;

		try {
			invoke( "updateObject", args, UPDATE_OBJECT_3, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateObject(java.lang.String param0, java.lang.Object param1, int param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = new Integer( param2 );

		try {
			invoke( "updateObject", args, UPDATE_OBJECT_4, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void insertRow() throws SQLException {
		try {
			invoke( "insertRow", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void updateRow() throws SQLException {
		try {
			invoke( "updateRow", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void deleteRow() throws SQLException {
		try {
			invoke( "deleteRow", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void refreshRow() throws SQLException {
		try {
			invoke( "refreshRow", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void cancelRowUpdates() throws SQLException {
		try {
			invoke( "cancelRowUpdates", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void moveToInsertRow() throws SQLException {
		try {
			invoke( "moveToInsertRow", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void moveToCurrentRow() throws SQLException {
		try {
			invoke( "moveToCurrentRow", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Statement getStatement() throws SQLException {
		try {
			return (java.sql.Statement)invoke( "getStatement", null, null, com.isnetworks.crypto.database.StatementProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Blob getBlob(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.sql.Blob)invoke( "getBlob", args, GET_BLOB_1, com.isnetworks.crypto.database.BlobProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Blob getBlob(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.Blob)invoke( "getBlob", args, GET_BLOB_2, com.isnetworks.crypto.database.BlobProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Clob getClob(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.Clob)invoke( "getClob", args, GET_CLOB_1, com.isnetworks.crypto.database.ClobProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Clob getClob(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.sql.Clob)invoke( "getClob", args, GET_CLOB_2, com.isnetworks.crypto.database.ClobProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Array getArray(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.sql.Array)invoke( "getArray", args, GET_ARRAY_1, com.isnetworks.crypto.database.ArrayProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Array getArray(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			return (java.sql.Array)invoke( "getArray", args, GET_ARRAY_2, com.isnetworks.crypto.database.ArrayProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
