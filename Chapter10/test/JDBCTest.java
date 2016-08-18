import java.sql.*;

public class JDBCTest {

	private static final String DRIVER_NAME="com.isnetworks.crypto.database.SecureDriver";
	private static final String DB_URL="jdbc:secureDriver://localhost/dataSource1";
	private static final String USERNAME="username";
	private static final String PASSWORD="password";

	private static final String QUERY="SELECT * FROM credit_card";

	public static void main(String[] args) throws Exception {
		Class.forName(DRIVER_NAME);
        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        Statement stmt = conn.createStatement();
        ResultSet rslt = stmt.executeQuery(QUERY);
        rslt.next();
        rslt.close();
        stmt.close();
        conn.close();
        System.out.println("Success! Connected to database.");
	}
}