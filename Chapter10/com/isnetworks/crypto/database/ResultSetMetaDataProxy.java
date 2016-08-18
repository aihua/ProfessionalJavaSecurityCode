package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ResultSetMetaDataProxy extends AbstractProxy implements ResultSetMetaData {

	private static final Class[] IS_READ_ONLY_1 = 
	{int.class};

	private static final Class[] IS_AUTO_INCREMENT_1 = 
	{int.class};

	private static final Class[] IS_CASE_SENSITIVE_1 = 
	{int.class};

	private static final Class[] IS_SEARCHABLE_1 = 
	{int.class};

	private static final Class[] IS_CURRENCY_1 = 
	{int.class};

	private static final Class[] IS_NULLABLE_1 = 
	{int.class};

	private static final Class[] IS_SIGNED_1 = 
	{int.class};

	private static final Class[] GET_COLUMN_DISPLAY_SIZE_1 = 
	{int.class};

	private static final Class[] GET_COLUMN_LABEL_1 = 
	{int.class};

	private static final Class[] GET_COLUMN_NAME_1 = 
	{int.class};

	private static final Class[] GET_SCHEMA_NAME_1 = 
	{int.class};

	private static final Class[] GET_PRECISION_1 = 
	{int.class};

	private static final Class[] GET_SCALE_1 = 
	{int.class};

	private static final Class[] GET_TABLE_NAME_1 = 
	{int.class};

	private static final Class[] GET_CATALOG_NAME_1 = 
	{int.class};

	private static final Class[] GET_COLUMN_TYPE_1 = 
	{int.class};

	private static final Class[] GET_COLUMN_TYPE_NAME_1 = 
	{int.class};

	private static final Class[] IS_WRITABLE_1 = 
	{int.class};

	private static final Class[] IS_DEFINITELY_WRITABLE_1 = 
	{int.class};

	private static final Class[] GET_COLUMN_CLASS_NAME_1 = 
	{int.class};

	public boolean isReadOnly(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "isReadOnly", args, IS_READ_ONLY_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getColumnCount() throws SQLException {
		try {
			return ((Integer)invoke( "getColumnCount", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isAutoIncrement(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "isAutoIncrement", args, IS_AUTO_INCREMENT_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isCaseSensitive(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "isCaseSensitive", args, IS_CASE_SENSITIVE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isSearchable(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "isSearchable", args, IS_SEARCHABLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isCurrency(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "isCurrency", args, IS_CURRENCY_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int isNullable(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Integer)invoke( "isNullable", args, IS_NULLABLE_1, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isSigned(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "isSigned", args, IS_SIGNED_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getColumnDisplaySize(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Integer)invoke( "getColumnDisplaySize", args, GET_COLUMN_DISPLAY_SIZE_1, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getColumnLabel(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.String)invoke( "getColumnLabel", args, GET_COLUMN_LABEL_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getColumnName(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.String)invoke( "getColumnName", args, GET_COLUMN_NAME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getSchemaName(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.String)invoke( "getSchemaName", args, GET_SCHEMA_NAME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getPrecision(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Integer)invoke( "getPrecision", args, GET_PRECISION_1, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getScale(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Integer)invoke( "getScale", args, GET_SCALE_1, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getTableName(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.String)invoke( "getTableName", args, GET_TABLE_NAME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getCatalogName(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.String)invoke( "getCatalogName", args, GET_CATALOG_NAME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getColumnType(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Integer)invoke( "getColumnType", args, GET_COLUMN_TYPE_1, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getColumnTypeName(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.String)invoke( "getColumnTypeName", args, GET_COLUMN_TYPE_NAME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isWritable(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "isWritable", args, IS_WRITABLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isDefinitelyWritable(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "isDefinitelyWritable", args, IS_DEFINITELY_WRITABLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getColumnClassName(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return (java.lang.String)invoke( "getColumnClassName", args, GET_COLUMN_CLASS_NAME_1, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}


}
