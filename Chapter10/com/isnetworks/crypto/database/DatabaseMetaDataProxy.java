package com.isnetworks.crypto.database;

import com.isnetworks.crypto.database.*;
import com.isnetworks.util.*;
import com.isnetworks.remote.proxy.*;
import java.lang.reflect.*;
import java.rmi.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class DatabaseMetaDataProxy extends AbstractProxy implements DatabaseMetaData {

	private static final Class[] SUPPORTS_CONVERT_2 = 
	{int.class, int.class};

	private static final Class[] SUPPORTS_TRANSACTION_ISOLATION_LEVEL_1 = 
	{int.class};

	private static final Class[] GET_PROCEDURES_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_PROCEDURE_COLUMNS_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_TABLES_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String[].class};

	private static final Class[] GET_COLUMNS_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_COLUMN_PRIVILEGES_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_TABLE_PRIVILEGES_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_BEST_ROW_IDENTIFIER_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class, int.class, boolean.class};

	private static final Class[] GET_VERSION_COLUMNS_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_PRIMARY_KEYS_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_IMPORTED_KEYS_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_EXPORTED_KEYS_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_CROSS_REFERENCE_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class};

	private static final Class[] GET_INDEX_INFO_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class, boolean.class, boolean.class};

	private static final Class[] SUPPORTS_RESULT_SET_TYPE_1 = 
	{int.class};

	private static final Class[] SUPPORTS_RESULT_SET_CONCURRENCY_1 = 
	{int.class, int.class};

	private static final Class[] OWN_UPDATES_ARE_VISIBLE_1 = 
	{int.class};

	private static final Class[] OWN_DELETES_ARE_VISIBLE_1 = 
	{int.class};

	private static final Class[] OWN_INSERTS_ARE_VISIBLE_1 = 
	{int.class};

	private static final Class[] OTHERS_UPDATES_ARE_VISIBLE_1 = 
	{int.class};

	private static final Class[] OTHERS_DELETES_ARE_VISIBLE_1 = 
	{int.class};

	private static final Class[] OTHERS_INSERTS_ARE_VISIBLE_1 = 
	{int.class};

	private static final Class[] UPDATES_ARE_DETECTED_1 = 
	{int.class};

	private static final Class[] DELETES_ARE_DETECTED_1 = 
	{int.class};

	private static final Class[] INSERTS_ARE_DETECTED_1 = 
	{int.class};

	private static final Class[] GET_UD_TS_1 = 
	{java.lang.String.class, java.lang.String.class, java.lang.String.class, int[].class};

	public java.lang.String getURL() throws SQLException {
		try {
			return (java.lang.String)invoke( "getURL", null, null, null );
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

	public boolean allProceduresAreCallable() throws SQLException {
		try {
			return ((Boolean)invoke( "allProceduresAreCallable", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean allTablesAreSelectable() throws SQLException {
		try {
			return ((Boolean)invoke( "allTablesAreSelectable", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getUserName() throws SQLException {
		try {
			return (java.lang.String)invoke( "getUserName", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean nullsAreSortedHigh() throws SQLException {
		try {
			return ((Boolean)invoke( "nullsAreSortedHigh", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean nullsAreSortedLow() throws SQLException {
		try {
			return ((Boolean)invoke( "nullsAreSortedLow", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean nullsAreSortedAtStart() throws SQLException {
		try {
			return ((Boolean)invoke( "nullsAreSortedAtStart", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean nullsAreSortedAtEnd() throws SQLException {
		try {
			return ((Boolean)invoke( "nullsAreSortedAtEnd", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getDatabaseProductName() throws SQLException {
		try {
			return (java.lang.String)invoke( "getDatabaseProductName", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getDatabaseProductVersion() throws SQLException {
		try {
			return (java.lang.String)invoke( "getDatabaseProductVersion", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getDriverName() throws SQLException {
		try {
			return (java.lang.String)invoke( "getDriverName", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getDriverVersion() throws SQLException {
		try {
			return (java.lang.String)invoke( "getDriverVersion", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getDriverMajorVersion() {
		try {
			return ((Integer)invoke( "getDriverMajorVersion", null, null, null )).intValue();
		}catch(Exception e){
			throw new UnsupportedOperationException(Debug.getStackTraceAsString(e));
		}
	}

	public int getDriverMinorVersion() {
		try {
			return ((Integer)invoke( "getDriverMinorVersion", null, null, null )).intValue();
		}catch(Exception e){
			throw new UnsupportedOperationException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean usesLocalFiles() throws SQLException {
		try {
			return ((Boolean)invoke( "usesLocalFiles", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean usesLocalFilePerTable() throws SQLException {
		try {
			return ((Boolean)invoke( "usesLocalFilePerTable", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsMixedCaseIdentifiers() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsMixedCaseIdentifiers", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean storesUpperCaseIdentifiers() throws SQLException {
		try {
			return ((Boolean)invoke( "storesUpperCaseIdentifiers", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean storesLowerCaseIdentifiers() throws SQLException {
		try {
			return ((Boolean)invoke( "storesLowerCaseIdentifiers", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean storesMixedCaseIdentifiers() throws SQLException {
		try {
			return ((Boolean)invoke( "storesMixedCaseIdentifiers", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsMixedCaseQuotedIdentifiers", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
		try {
			return ((Boolean)invoke( "storesUpperCaseQuotedIdentifiers", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
		try {
			return ((Boolean)invoke( "storesLowerCaseQuotedIdentifiers", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
		try {
			return ((Boolean)invoke( "storesMixedCaseQuotedIdentifiers", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getIdentifierQuoteString() throws SQLException {
		try {
			return (java.lang.String)invoke( "getIdentifierQuoteString", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getSQLKeywords() throws SQLException {
		try {
			return (java.lang.String)invoke( "getSQLKeywords", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getNumericFunctions() throws SQLException {
		try {
			return (java.lang.String)invoke( "getNumericFunctions", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getStringFunctions() throws SQLException {
		try {
			return (java.lang.String)invoke( "getStringFunctions", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getSystemFunctions() throws SQLException {
		try {
			return (java.lang.String)invoke( "getSystemFunctions", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getTimeDateFunctions() throws SQLException {
		try {
			return (java.lang.String)invoke( "getTimeDateFunctions", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getSearchStringEscape() throws SQLException {
		try {
			return (java.lang.String)invoke( "getSearchStringEscape", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getExtraNameCharacters() throws SQLException {
		try {
			return (java.lang.String)invoke( "getExtraNameCharacters", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsAlterTableWithAddColumn() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsAlterTableWithAddColumn", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsAlterTableWithDropColumn() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsAlterTableWithDropColumn", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsColumnAliasing() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsColumnAliasing", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean nullPlusNonNullIsNull() throws SQLException {
		try {
			return ((Boolean)invoke( "nullPlusNonNullIsNull", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsConvert() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsConvert", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsConvert(int param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			return ((Boolean)invoke( "supportsConvert", args, SUPPORTS_CONVERT_2, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsTableCorrelationNames() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsTableCorrelationNames", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsDifferentTableCorrelationNames() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsDifferentTableCorrelationNames", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsExpressionsInOrderBy() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsExpressionsInOrderBy", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsOrderByUnrelated() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsOrderByUnrelated", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsGroupBy() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsGroupBy", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsGroupByUnrelated() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsGroupByUnrelated", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsGroupByBeyondSelect() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsGroupByBeyondSelect", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsLikeEscapeClause() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsLikeEscapeClause", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsMultipleResultSets() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsMultipleResultSets", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsMultipleTransactions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsMultipleTransactions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsNonNullableColumns() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsNonNullableColumns", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsMinimumSQLGrammar() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsMinimumSQLGrammar", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsCoreSQLGrammar() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsCoreSQLGrammar", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsExtendedSQLGrammar() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsExtendedSQLGrammar", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsANSI92EntryLevelSQL() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsANSI92EntryLevelSQL", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsANSI92IntermediateSQL() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsANSI92IntermediateSQL", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsANSI92FullSQL() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsANSI92FullSQL", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsIntegrityEnhancementFacility() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsIntegrityEnhancementFacility", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsOuterJoins() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsOuterJoins", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsFullOuterJoins() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsFullOuterJoins", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsLimitedOuterJoins() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsLimitedOuterJoins", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getSchemaTerm() throws SQLException {
		try {
			return (java.lang.String)invoke( "getSchemaTerm", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getProcedureTerm() throws SQLException {
		try {
			return (java.lang.String)invoke( "getProcedureTerm", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getCatalogTerm() throws SQLException {
		try {
			return (java.lang.String)invoke( "getCatalogTerm", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean isCatalogAtStart() throws SQLException {
		try {
			return ((Boolean)invoke( "isCatalogAtStart", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.lang.String getCatalogSeparator() throws SQLException {
		try {
			return (java.lang.String)invoke( "getCatalogSeparator", null, null, null );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSchemasInDataManipulation() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSchemasInDataManipulation", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSchemasInProcedureCalls() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSchemasInProcedureCalls", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSchemasInTableDefinitions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSchemasInTableDefinitions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSchemasInIndexDefinitions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSchemasInIndexDefinitions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSchemasInPrivilegeDefinitions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsCatalogsInDataManipulation() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsCatalogsInDataManipulation", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsCatalogsInProcedureCalls() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsCatalogsInProcedureCalls", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsCatalogsInTableDefinitions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsCatalogsInTableDefinitions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsCatalogsInIndexDefinitions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsCatalogsInPrivilegeDefinitions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsPositionedDelete() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsPositionedDelete", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsPositionedUpdate() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsPositionedUpdate", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSelectForUpdate() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSelectForUpdate", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsStoredProcedures() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsStoredProcedures", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSubqueriesInComparisons() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSubqueriesInComparisons", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSubqueriesInExists() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSubqueriesInExists", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSubqueriesInIns() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSubqueriesInIns", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsSubqueriesInQuantifieds() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsSubqueriesInQuantifieds", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsCorrelatedSubqueries() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsCorrelatedSubqueries", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsUnion() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsUnion", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsUnionAll() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsUnionAll", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsOpenCursorsAcrossCommit", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsOpenCursorsAcrossRollback", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsOpenStatementsAcrossCommit", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsOpenStatementsAcrossRollback", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxBinaryLiteralLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxBinaryLiteralLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxCharLiteralLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxCharLiteralLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxColumnNameLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxColumnNameLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxColumnsInGroupBy() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxColumnsInGroupBy", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxColumnsInIndex() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxColumnsInIndex", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxColumnsInOrderBy() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxColumnsInOrderBy", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxColumnsInSelect() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxColumnsInSelect", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxColumnsInTable() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxColumnsInTable", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxConnections() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxConnections", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxCursorNameLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxCursorNameLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxIndexLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxIndexLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxSchemaNameLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxSchemaNameLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxProcedureNameLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxProcedureNameLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxCatalogNameLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxCatalogNameLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxRowSize() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxRowSize", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
		try {
			return ((Boolean)invoke( "doesMaxRowSizeIncludeBlobs", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxStatementLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxStatementLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxStatements() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxStatements", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxTableNameLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxTableNameLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxTablesInSelect() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxTablesInSelect", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getMaxUserNameLength() throws SQLException {
		try {
			return ((Integer)invoke( "getMaxUserNameLength", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public int getDefaultTransactionIsolation() throws SQLException {
		try {
			return ((Integer)invoke( "getDefaultTransactionIsolation", null, null, null )).intValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsTransactions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsTransactions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsTransactionIsolationLevel(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "supportsTransactionIsolationLevel", args, SUPPORTS_TRANSACTION_ISOLATION_LEVEL_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsDataDefinitionAndDataManipulationTransactions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsDataManipulationTransactionsOnly", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
		try {
			return ((Boolean)invoke( "dataDefinitionCausesTransactionCommit", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
		try {
			return ((Boolean)invoke( "dataDefinitionIgnoredInTransactions", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getProcedures(java.lang.String param0, java.lang.String param1, java.lang.String param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			return (java.sql.ResultSet)invoke( "getProcedures", args, GET_PROCEDURES_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getProcedureColumns(java.lang.String param0, java.lang.String param1, java.lang.String param2, java.lang.String param3) throws SQLException {
		Object args[] = new Object[ 4 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;
		args[ 3 ] = param3;

		try {
			return (java.sql.ResultSet)invoke( "getProcedureColumns", args, GET_PROCEDURE_COLUMNS_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getTables(java.lang.String param0, java.lang.String param1, java.lang.String param2, java.lang.String[] param3) throws SQLException {
		Object args[] = new Object[ 4 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;
		args[ 3 ] = param3;

		try {
			return (java.sql.ResultSet)invoke( "getTables", args, GET_TABLES_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getSchemas() throws SQLException {
		try {
			return (java.sql.ResultSet)invoke( "getSchemas", null, null, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getCatalogs() throws SQLException {
		try {
			return (java.sql.ResultSet)invoke( "getCatalogs", null, null, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getTableTypes() throws SQLException {
		try {
			return (java.sql.ResultSet)invoke( "getTableTypes", null, null, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getColumns(java.lang.String param0, java.lang.String param1, java.lang.String param2, java.lang.String param3) throws SQLException {
		Object args[] = new Object[ 4 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;
		args[ 3 ] = param3;

		try {
			return (java.sql.ResultSet)invoke( "getColumns", args, GET_COLUMNS_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getColumnPrivileges(java.lang.String param0, java.lang.String param1, java.lang.String param2, java.lang.String param3) throws SQLException {
		Object args[] = new Object[ 4 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;
		args[ 3 ] = param3;

		try {
			return (java.sql.ResultSet)invoke( "getColumnPrivileges", args, GET_COLUMN_PRIVILEGES_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getTablePrivileges(java.lang.String param0, java.lang.String param1, java.lang.String param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			return (java.sql.ResultSet)invoke( "getTablePrivileges", args, GET_TABLE_PRIVILEGES_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getBestRowIdentifier(java.lang.String param0, java.lang.String param1, java.lang.String param2, int param3, boolean param4) throws SQLException {
		Object args[] = new Object[ 5 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;
		args[ 3 ] = new Integer( param3 );
		args[ 4 ] = new Boolean( param4 );

		try {
			return (java.sql.ResultSet)invoke( "getBestRowIdentifier", args, GET_BEST_ROW_IDENTIFIER_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getVersionColumns(java.lang.String param0, java.lang.String param1, java.lang.String param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			return (java.sql.ResultSet)invoke( "getVersionColumns", args, GET_VERSION_COLUMNS_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getPrimaryKeys(java.lang.String param0, java.lang.String param1, java.lang.String param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			return (java.sql.ResultSet)invoke( "getPrimaryKeys", args, GET_PRIMARY_KEYS_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getImportedKeys(java.lang.String param0, java.lang.String param1, java.lang.String param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			return (java.sql.ResultSet)invoke( "getImportedKeys", args, GET_IMPORTED_KEYS_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getExportedKeys(java.lang.String param0, java.lang.String param1, java.lang.String param2) throws SQLException {
		Object args[] = new Object[ 3 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;

		try {
			return (java.sql.ResultSet)invoke( "getExportedKeys", args, GET_EXPORTED_KEYS_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getCrossReference(java.lang.String param0, java.lang.String param1, java.lang.String param2, java.lang.String param3, java.lang.String param4, java.lang.String param5) throws SQLException {
		Object args[] = new Object[ 6 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;
		args[ 3 ] = param3;
		args[ 4 ] = param4;
		args[ 5 ] = param5;

		try {
			return (java.sql.ResultSet)invoke( "getCrossReference", args, GET_CROSS_REFERENCE_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getTypeInfo() throws SQLException {
		try {
			return (java.sql.ResultSet)invoke( "getTypeInfo", null, null, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getIndexInfo(java.lang.String param0, java.lang.String param1, java.lang.String param2, boolean param3, boolean param4) throws SQLException {
		Object args[] = new Object[ 5 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;
		args[ 3 ] = new Boolean( param3 );
		args[ 4 ] = new Boolean( param4 );

		try {
			return (java.sql.ResultSet)invoke( "getIndexInfo", args, GET_INDEX_INFO_1, com.isnetworks.crypto.database.ResultSetProxy.class );
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsResultSetType(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "supportsResultSetType", args, SUPPORTS_RESULT_SET_TYPE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsResultSetConcurrency(int param0, int param1) throws SQLException {
		Object args[] = new Object[ 2 ];
		args[ 0 ] = new Integer( param0 );
		args[ 1 ] = new Integer( param1 );

		try {
			return ((Boolean)invoke( "supportsResultSetConcurrency", args, SUPPORTS_RESULT_SET_CONCURRENCY_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean ownUpdatesAreVisible(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "ownUpdatesAreVisible", args, OWN_UPDATES_ARE_VISIBLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean ownDeletesAreVisible(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "ownDeletesAreVisible", args, OWN_DELETES_ARE_VISIBLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean ownInsertsAreVisible(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "ownInsertsAreVisible", args, OWN_INSERTS_ARE_VISIBLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean othersUpdatesAreVisible(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "othersUpdatesAreVisible", args, OTHERS_UPDATES_ARE_VISIBLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean othersDeletesAreVisible(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "othersDeletesAreVisible", args, OTHERS_DELETES_ARE_VISIBLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean othersInsertsAreVisible(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "othersInsertsAreVisible", args, OTHERS_INSERTS_ARE_VISIBLE_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean updatesAreDetected(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "updatesAreDetected", args, UPDATES_ARE_DETECTED_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean deletesAreDetected(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "deletesAreDetected", args, DELETES_ARE_DETECTED_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean insertsAreDetected(int param0) throws SQLException {
		Object args[] = new Object[ 1 ];
		args[ 0 ] = new Integer( param0 );

		try {
			return ((Boolean)invoke( "insertsAreDetected", args, INSERTS_ARE_DETECTED_1, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public boolean supportsBatchUpdates() throws SQLException {
		try {
			return ((Boolean)invoke( "supportsBatchUpdates", null, null, null )).booleanValue();
		}catch(InvocationTargetException e){
			throw (SQLException)e.getTargetException();
		}catch(RemoteException e){
			throw new RemoteSQLException(Debug.getStackTraceAsString(e));
		}
	}

	public java.sql.ResultSet getUDTs(java.lang.String param0, java.lang.String param1, java.lang.String param2, int[] param3) throws SQLException {
		Object args[] = new Object[ 4 ];
		args[ 0 ] = param0;
		args[ 1 ] = param1;
		args[ 2 ] = param2;
		args[ 3 ] = param3;

		try {
			return (java.sql.ResultSet)invoke( "getUDTs", args, GET_UD_TS_1, com.isnetworks.crypto.database.ResultSetProxy.class );
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
