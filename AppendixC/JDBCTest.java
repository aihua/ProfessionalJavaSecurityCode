import java.sql.*;

public class JDBCTest {

	private static final String DRIVER_NAME="org.gjt.mm.mysql.Driver";
	private static final String DB_URL="jdbc:mysql://localhost/projava";
	private static final String USERNAME="projava";
	private static final String PASSWORD="sasquatch";

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