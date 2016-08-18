package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class SQLInputProxy extends AbstractProxy implements SQLInput {

	public java.lang.Object readObject() throws SQLException {
		try {
			return (java.lang.Object)invoke( "readObject", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int readInt() throws SQLException {
		try {
			return ((Integer)invoke( "readInt", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public byte readByte() throws SQLException {
		try {
			return ((Byte)invoke( "readByte", null, null, null )).byteValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public short readShort() throws SQLException {
		try {
			return ((Short)invoke( "readShort", null, null, null )).shortValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public byte[] readBytes() throws SQLException {
		try {
			return (byte[])invoke( "readBytes", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public float readFloat() throws SQLException {
		try {
			return ((Float)invoke( "readFloat", null, null, null )).floatValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean readBoolean() throws SQLException {
		try {
			return ((Boolean)invoke( "readBoolean", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public long readLong() throws SQLException {
		try {
			return ((Long)invoke( "readLong", null, null, null )).longValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public double readDouble() throws SQLException {
		try {
			return ((Double)invoke( "readDouble", null, null, null )).doubleValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String readString() throws SQLException {
		try {
			return (java.lang.String)invoke( "readString", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.math.BigDecimal readBigDecimal() throws SQLException {
		try {
			return (java.math.BigDecimal)invoke( "readBigDecimal", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Date readDate() throws SQLException {
		try {
			return (java.sql.Date)invoke( "readDate", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Time readTime() throws SQLException {
		try {
			return (java.sql.Time)invoke( "readTime", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Timestamp readTimestamp() throws SQLException {
		try {
			return (java.sql.Timestamp)invoke( "readTimestamp", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.Reader readCharacterStream() throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public java.io.InputStream readAsciiStream() throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public java.io.InputStream readBinaryStream() throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public java.sql.Ref readRef() throws SQLException {
		try {
			return (java.sql.Ref)invoke( "readRef", null, null, com.isnetworks.crypto.database.RefProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Blob readBlob() throws SQLException {
		try {
			return (java.sql.Blob)invoke( "readBlob", null, null, com.isnetworks.crypto.database.BlobProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Clob readClob() throws SQLException {
		try {
			return (java.sql.Clob)invoke( "readClob", null, null, com.isnetworks.crypto.database.ClobProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.Array readArray() throws SQLException {
		try {
			return (java.sql.Array)invoke( "readArray", null, null, com.isnetworks.crypto.database.ArrayProxy.class );
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


}
