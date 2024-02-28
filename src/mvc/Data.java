package mvc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data {
	static Connection getConnection() throws ClassNotFoundException, SQLException {	
		try {
			Connection connection = null;
//			String url = "jdbc:mysql://localhost:3306/mydata1";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String userName = "sa";
			String password = "1234567";
			String url = "jdbc:sqlserver://DESKTOP-JL3DGB8\\SQLEXPRESS01:1433;databaseName=Demojava";
				connection = DriverManager.getConnection(url, userName,password );		
				return connection;		
		} catch(Exception e) {
			System.out.println("connect error");
		}
		return null;
		
	}
}
