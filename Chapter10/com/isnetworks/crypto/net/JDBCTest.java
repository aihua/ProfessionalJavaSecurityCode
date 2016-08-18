/*
 * JDBCTest.java
 *
 * Created on April 22, 2000, 11:16 PM
 */

package com.isnetworks.crypto.net;

/**
 *
 * @author  dans
 * @version
 */
import java.sql.*;
public class JDBCTest extends Thread {
	
  private static long startTime = new java.util.Date().getTime();
  
  private int mClientCount = 0;
  
  private String mHost;

  private int mPort;
  
  public JDBCTest (int count, String host, int port) {
    mClientCount = count;
    mHost = host;
    mPort = port;
  }
  
  public void run () {
    try {
      printNow("start");
      Class.forName("postgresql.Driver");
      printNow("driver initialized");
      Connection conn = DriverManager.getConnection("jdbc:postgresql://" + mHost + ":" +
        mPort + "/projava",
      "projava", "");
      printNow("connection fetched");
      Statement stmt = conn.createStatement();
      printNow("statement created");
      ResultSet rslt = stmt.executeQuery("SELECT * FROM credit_card");
      printNow("resultset fetched");
      while (rslt.next()) {
        System.out.println(rslt.getString("account_id"));
      }
      printNow("printed");
      rslt.close();
      stmt.close();
      conn.close();
      printNow("done");
    }catch(Exception e){
      e.printStackTrace();
    }
  }

  public void printNow(String msg) {
    long time = new java.util.Date().getTime();
    System.out.println(mClientCount + ": " + msg + " at " + (time - startTime));
  }
  
  public static void main (String args[]) throws Exception {
    for (int x=0; x<5; x++) {
      new JDBCTest(x, args[0], Integer.parseInt(args[1])).start();
    }
  }
}
