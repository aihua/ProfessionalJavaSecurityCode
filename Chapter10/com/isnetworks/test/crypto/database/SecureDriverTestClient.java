
/**
 * SecureDriverTestClient.java
 *
 *
 * Created: Tue Feb  8 15:57:15 2000
 *
 * @author Daniel R. Somerfield
 * @version 1.0
 */
package com.isnetworks.test.crypto.database;
/**
 * Test fetching secure connections
 */
import java.sql.*;
import com.isnetworks.remote.proxy.*;
public class SecureDriverTestClient  {

	public static void main (String [] args){
		try{
			Class.forName("com.isnetworks.crypto.database.SecureDriver");
			Connection con = DriverManager.getConnection
				("jdbc:secureDriver://localhost/dataSource1");
			System.out.println("Got object: " + con);
			System.out.println("Proxy object: " + ((AbstractProxy)con).getOperationProxy());
			System.out.println("Autocommit: " + con.getAutoCommit());
			con.setAutoCommit(true);
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery( "SELECT * FROM Account" );
			while ( resultSet.next() ) {
				System.out.println( "Account id: " + resultSet.getInt( "account_id" ) );
				System.out.println( "Balance: " + resultSet.getFloat( "balance" ) );
				System.out.println( "Name: " + resultSet.getString( "customer_name" ) );
				System.out.println( "Serial number: " + resultSet.getString( "cert_serial_number" ) );				
			}
			resultSet.close();
			
			stmt.executeUpdate( "UPDATE Account SET balance=300 WHERE account_id = 1" );
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
