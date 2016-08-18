package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class BlobProxy extends AbstractProxy implements Blob {

	private static final Class[] GET_BYTES_1 = 
	{long.class, int.class};

	private static final Class[] POSITION_1 = 
	{java.sql.Blob.class, long.class};

	private static final Class[] POSITION_2 = 
	{byte[].class, long.class};

	public long length() throws SQLException {
		try {
			return ((Long)invoke( "length", null, null, null )).longValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public byte[] getBytes(long param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Long( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			return (byte[])invoke( "getBytes", args, GET_BYTES_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.io.InputStream getBinaryStream() throws SQLException {
            throw new UnsupportedOperationException("Not implemented.");
	}

	public long position(java.sql.Blob param0, long param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Long( param1 );

		try {
			return ((Long)invoke( "position", args, POSITION_1, null )).longValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public long position(byte[] param0, long param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = param0;
		args[ 1 ] = new Long( param1 );

		try {
			return ((Long)invoke( "position", args, POSITION_2, null )).longValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
