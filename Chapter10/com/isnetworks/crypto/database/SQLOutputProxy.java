package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SQLOutputProxy extends AbstractProxy implements SQLOutput {

	private static final Class[] WRITE_OBJECT_1 = 
	{java.sql.SQLData.class};

	private static final Class[] WRITE_INT_1 = 
	{int.class};

	private static final Class[] WRITE_BYTE_1 = 
	{byte.class};

	private static final Class[] WRITE_SHORT_1 = 
	{short.class};

	private static final Class[] WRITE_BYTES_1 = 
	{byte[].class};

	private static final Class[] WRITE_FLOAT_1 = 
	{float.class};

	private static final Class[] WRITE_STRING_1 = 
	{java.lang.String.class};

	private static final Class[] WRITE_BOOLEAN_1 = 
	{boolean.class};

	private static final Class[] WRITE_LONG_1 = 
	{long.class};

	private static final Class[] WRITE_DOUBLE_1 = 
	{double.class};

	private static final Class[] WRITE_BIG_DECIMAL_1 = 
	{java.math.BigDecimal.class};

	private static final Class[] WRITE_DATE_1 = 
	{java.sql.Date.class};

	private static final Class[] WRITE_TIME_1 = 
	{java.sql.Time.class};

	private static final Class[] WRITE_TIMESTAMP_1 = 
	{java.sql.Timestamp.class};

	private static final Class[] WRITE_CHARACTER_STREAM_1 = 
	{java.io.Reader.class};

	private static final Class[] WRITE_ASCII_STREAM_1 = 
	{java.io.InputStream.class};

	private static final Class[] WRITE_BINARY_STREAM_1 = 
	{java.io.InputStream.class};

	private static final Class[] WRITE_REF_1 = 
	{java.sql.Ref.class};

	private static final Class[] WRITE_BLOB_1 = 
	{java.sql.Blob.class};

	private static final Class[] WRITE_CLOB_1 = 
	{java.sql.Clob.class};

	private static final Class[] WRITE_STRUCT_1 = 
	{java.sql.Struct.class};

	private static final Class[] WRITE_ARRAY_1 = 
	{java.sql.Array.class};

	public void writeObject(java.sql.SQLData param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeObject", args, WRITE_OBJECT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeInt(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			invoke( "writeInt", args, WRITE_INT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeByte(byte param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Byte( param0 );

		try {
			invoke( "writeByte", args, WRITE_BYTE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeShort(short param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Short( param0 );

		try {
			invoke( "writeShort", args, WRITE_SHORT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeBytes(byte[] param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeBytes", args, WRITE_BYTES_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeFloat(float param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Float( param0 );

		try {
			invoke( "writeFloat", args, WRITE_FLOAT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeString(java.lang.String param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeString", args, WRITE_STRING_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeBoolean(boolean param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Boolean( param0 );

		try {
			invoke( "writeBoolean", args, WRITE_BOOLEAN_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeLong(long param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Long( param0 );

		try {
			invoke( "writeLong", args, WRITE_LONG_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeDouble(double param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Double( param0 );

		try {
			invoke( "writeDouble", args, WRITE_DOUBLE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeBigDecimal(java.math.BigDecimal param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeBigDecimal", args, WRITE_BIG_DECIMAL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeDate(java.sql.Date param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeDate", args, WRITE_DATE_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeTime(java.sql.Time param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeTime", args, WRITE_TIME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeTimestamp(java.sql.Timestamp param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeTimestamp", args, WRITE_TIMESTAMP_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeCharacterStream(java.io.Reader param0) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void writeAsciiStream(java.io.InputStream param0) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void writeBinaryStream(java.io.InputStream param0) throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public void writeRef(java.sql.Ref param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeRef", args, WRITE_REF_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeBlob(java.sql.Blob param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeBlob", args, WRITE_BLOB_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeClob(java.sql.Clob param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeClob", args, WRITE_CLOB_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeStruct(java.sql.Struct param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeStruct", args, WRITE_STRUCT_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public void writeArray(java.sql.Array param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = param0;

		try {
			invoke( "writeArray", args, WRITE_ARRAY_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
