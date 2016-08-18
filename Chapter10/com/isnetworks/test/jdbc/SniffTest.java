
/**
 * SniffTest.java
 *
 *
 * Created: Fri Feb 18 10:42:34 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */

package com.isnetworks.test.jdbc;
/**
 * A simple database connection to show what's on the wire
 */
import java.sql.*;
public class SniffTest  {
	
	private static final String SQL = "SELECT * FROM sniff_table";
	/**
	 * Main entry point for SniffTest.class
	 */
	public static void main (String [] args){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rslt = null;

		if (args.length < 1){
			usage();
			System.exit(2);
		}

		String url = args[0];
		String username = "crypto";
		String password = "";
		if (args.length > 1){
			username = args[1];
		}

		if (args.length > 2){
			username = args[2];
		}

		try{
			Class.forName("postgresql.Driver");
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.prepareStatement(SQL);
			rslt = stmt.executeQuery();
			while (rslt.next()){
				System.out.println("ID: " + rslt.getString("secret_id"));
				System.out.println("Credit card: " + 
								   rslt.getString("credit_card"));
				System.out.println("------");
			}
			  
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (conn != null){
					conn.close();
				}
				if (stmt != null){
					stmt.close();
				}
				if (rslt != null){
					rslt.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}


	private static void usage(){
		System.err.println("java com.isnetworks.test.jdbc.SniffTest url " +
						   "[username] [password]");
	}
	
}
