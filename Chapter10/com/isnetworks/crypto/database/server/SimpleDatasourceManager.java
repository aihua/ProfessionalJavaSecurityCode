/**
 * @(#) SimpleDatasourceManager.java
 */

package com.isnetworks.crypto.database.server;
/**
 * Simple implementation of the DatasourceManager interface
 */
import java.sql.*;
import java.util.*;
import com.isnetworks.util.*;
public class SimpleDatasourceManager implements DatasourceManager{

  private Hashtable mDatasources = new Hashtable();

  public SimpleDatasourceManager (XMLProperties props)
  throws ConfigurationException{

    try{
      Iterator iter = props.getProperty("dataSource").iterator();
      XMLProperties dsProps;
      Datasource ds;
      String id;
      while (iter.hasNext()){
        dsProps =  (XMLProperties)iter.next();
        id = (String)dsProps.getProperty("id").
        iterator().next();
        ds = new Datasource(dsProps);
        mDatasources.put(id, ds);
      }

    }catch (SQLException e){
      throw new ConfigurationException("SimpleDatasourceManager() failed", e);
    }
  }

  public Connection getConnection( String dataSource,
  String username,
  String password )
  throws SQLException{

    Datasource ds = (Datasource)mDatasources.get(dataSource);
    if (ds==null){
      throw new SQLException("A datasource named " + dataSource +
      " was not found.");
    }
    return ds.getConnection(username, password);
  }

  /**
   * Inner convenience Class for datasources
   */
  class Datasource {

    private String mDriver;
    private String mURL;
    private String mUsername;
    private String mPassword;
    private boolean mLoginRequired;
    private HashMap mLogins = new HashMap();

    public Datasource(XMLProperties datasourceConfig)
    throws SQLException{

      mDriver = (String)datasourceConfig.getProperty("driver").
      iterator().next();
      mURL = (String)datasourceConfig.getProperty("url").
      iterator().next();
      mUsername = (String)datasourceConfig.getProperty("username").
      iterator().next();
      mPassword = (String)datasourceConfig.getProperty("password").
      iterator().next();

      String loginRequired = (String)datasourceConfig.getProperty("loginRequired").
      iterator().next();
      if ("false".equals(loginRequired)) {
        mLoginRequired = false;
      } else {
        mLoginRequired = true;
      }

      Iterator logins = datasourceConfig.getProperty("login").iterator();
      String username;
      String password;
      XMLProperties props;
      System.out.println("Adding logins to DatasourceManager.");
      while (logins.hasNext()) {
        props = (XMLProperties)logins.next();
        username = ((String)props.getProperty("username").iterator().next()).trim();
        password = ((String)props.getProperty("password").iterator().next()).trim();
        System.out.println("Adding login: " + username + "/" + password);
        mLogins.put(username, password);
      }
      
      try {
        Class.forName(mDriver);
      } catch(Exception e) {
        throw new SQLException("The JDBC driver " + mDriver +" failed to load.");
      }

    }

    public Connection getConnection(String username, String password)
    throws SQLException{

      //Check if a login and password
      if (mLoginRequired){
        String pwd = (String)mLogins.get(username);
        if (pwd != null) {
            pwd = pwd.trim();
        }
        
        if (password == null) {
            password = "";
        }
               
        if (!password.trim().equals(pwd)){
          throw new SQLException ("Incorrect login to access datasource.");
        }
      }

      //This should really delegate to a connection pool

      return DriverManager.getConnection(mURL, mUsername, mPassword);

    }

    public String toString(){
      StringBuffer buffer = new StringBuffer();
      buffer.append("Datasource: ");
      buffer.append("\n driver: " + mDriver);
      buffer.append("\n url: " + mURL);
      buffer.append("\n username: " + mUsername);
      return buffer.toString();
    }

  }
}
