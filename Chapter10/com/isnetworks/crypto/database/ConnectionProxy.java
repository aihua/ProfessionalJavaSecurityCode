package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectionProxy extends AbstractProxy implements Connection {
  private static final Class[] SET_READ_ONLY_1 = {boolean.class};

  private static final Class[] CREATE_STATEMENT_2 = {int.class, int.class};

  private static final Class[] PREPARE_STATEMENT_1 = {java.lang.String.class};

  private static final Class[] PREPARE_STATEMENT_2 = 
  {java.lang.String.class, int.class, int.class};

  private static final Class[] PREPARE_CALL_1 = 
  {java.lang.String.class};

  private static final Class[] PREPARE_CALL_2 = 
  {java.lang.String.class, int.class, int.class};

  private static final Class[] NATIVE_SQL_1 = 
  {java.lang.String.class};

  private static final Class[] SET_AUTO_COMMIT_1 = 
  {boolean.class};

  private static final Class[] SET_CATALOG_1 = 
  {java.lang.String.class};

  private static final Class[] SET_TRANSACTION_ISOLATION_1 = 
  {int.class};

  private static final Class[] SET_TYPE_MAP_1 = 
  {java.util.Map.class};

  public void setReadOnly(boolean param0) throws SQLException {
    Object args[] = new Object[ 1 ];
    args[ 0 ] = new Boolean( param0 );

    try {
      invoke( "setReadOnly", args, SET_READ_ONLY_1, null );
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

  public boolean isClosed() throws SQLException {
    try {
      return ((Boolean)invoke( "isClosed", null, null, null )).booleanValue();
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public boolean isReadOnly() throws SQLException {
    try {
      return ((Boolean)invoke( "isReadOnly", null, null, null )).booleanValue();
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.sql.Statement createStatement() throws SQLException {
    try {
      return (java.sql.Statement)invoke( "createStatement", null, null, com.isnetworks.crypto.database.StatementProxy.class );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.sql.Statement createStatement(int param0, int param1) throws SQLException {
    Object args[] = new Object[ 2 ];
    args[ 0 ] = new Integer( param0 );
    args[ 1 ] = new Integer( param1 );

    try {
      return (java.sql.Statement)invoke( "createStatement", args, CREATE_STATEMENT_2, com.isnetworks.crypto.database.StatementProxy.class );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.sql.PreparedStatement prepareStatement(java.lang.String param0) throws SQLException {
    Object args[] = new Object[ 1 ];
    args[ 0 ] = param0;

    try {
      return (java.sql.PreparedStatement)invoke( "prepareStatement", args, PREPARE_STATEMENT_1, com.isnetworks.crypto.database.PreparedStatementProxy.class );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.sql.PreparedStatement prepareStatement(java.lang.String param0, int param1, int param2) throws SQLException {
    Object args[] = new Object[ 3 ];
    args[ 0 ] = param0;
    args[ 1 ] = new Integer( param1 );
    args[ 2 ] = new Integer( param2 );

    try {
      return (java.sql.PreparedStatement)invoke( "prepareStatement", args, PREPARE_STATEMENT_2, com.isnetworks.crypto.database.PreparedStatementProxy.class );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.sql.CallableStatement prepareCall(java.lang.String param0) throws SQLException {
    Object args[] = new Object[ 1 ];
    args[ 0 ] = param0;

    try {
      return (java.sql.CallableStatement)invoke( "prepareCall", args, PREPARE_CALL_1, com.isnetworks.crypto.database.CallableStatementProxy.class );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.sql.CallableStatement prepareCall(java.lang.String param0, int param1, int param2) throws SQLException {
    Object args[] = new Object[ 3 ];
    args[ 0 ] = param0;
    args[ 1 ] = new Integer( param1 );
    args[ 2 ] = new Integer( param2 );

    try {
      return (java.sql.CallableStatement)invoke( "prepareCall", args, PREPARE_CALL_2, com.isnetworks.crypto.database.CallableStatementProxy.class );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.lang.String nativeSQL(java.lang.String param0) throws SQLException {
    Object args[] = new Object[ 1 ];
    args[ 0 ] = param0;

    try {
      return (java.lang.String)invoke( "nativeSQL", args, NATIVE_SQL_1, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public void setAutoCommit(boolean param0) throws SQLException {
    Object args[] = new Object[ 1 ];
    args[ 0 ] = new Boolean( param0 );

    try {
      invoke( "setAutoCommit", args, SET_AUTO_COMMIT_1, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public boolean getAutoCommit() throws SQLException {
    try {
      return ((Boolean)invoke( "getAutoCommit", null, null, null )).booleanValue();
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public void commit() throws SQLException {
    try {
      invoke( "commit", null, null, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public void rollback() throws SQLException {
    try {
      invoke( "rollback", null, null, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.sql.DatabaseMetaData getMetaData() throws SQLException {
    try {
      return (java.sql.DatabaseMetaData)invoke( "getMetaData", null, null, com.isnetworks.crypto.database.DatabaseMetaDataProxy.class );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public void setCatalog(java.lang.String param0) throws SQLException {
    Object args[] = new Object[ 1 ];
    args[ 0 ] = param0;

    try {
      invoke( "setCatalog", args, SET_CATALOG_1, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public java.lang.String getCatalog() throws SQLException {
    try {
      return (java.lang.String)invoke( "getCatalog", null, null, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public void setTransactionIsolation(int param0) throws SQLException {
    Object args[] = new Object[ 1 ];
    args[ 0 ] = new Integer( param0 );

    try {
      invoke( "setTransactionIsolation", args, SET_TRANSACTION_ISOLATION_1, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public int getTransactionIsolation() throws SQLException {
    try {
      return ((Integer)invoke( "getTransactionIsolation", null, null, null )).intValue();
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

  public java.util.Map getTypeMap() throws SQLException {
    try {
      return (java.util.Map)invoke( "getTypeMap", null, null, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

  public void setTypeMap(java.util.Map param0) throws SQLException {
    Object args[] = new Object[ 1 ];
    args[ 0 ] = param0;

    try {
      invoke( "setTypeMap", args, SET_TYPE_MAP_1, null );
    }catch(InvocationTargetException e){
      throw (SQLException)e.getTargetException();
    }catch(RemoteException e){
      throw new RemoteSQLException(Debug.getStackTraceAsString(e));
    }
  }

}
