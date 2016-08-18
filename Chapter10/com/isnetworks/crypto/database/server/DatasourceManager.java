/**
 * @(#) DataSourceManager.java
 */

package com.isnetworks.crypto.database.server;
import java.sql.*;
public interface DatasourceManager {

    public Connection getConnection( String dataSource, String username, String password )
		throws SQLException;
    
    
}
