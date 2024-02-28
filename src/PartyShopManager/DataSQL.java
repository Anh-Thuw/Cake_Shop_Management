package PartyShopManagerThuQuynh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSQL {

	static Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			Connection connection = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String userName = "anhthu";
			String password = "1234567";
			String url = "jdbc:sqlserver://DESKTOP-JL3DGB8\\SQLEXPRESS01:1433;databaseName=BanhKem";
			connection = DriverManager.getConnection(url, userName, password);
			return connection;
		} catch (Exception e) {
			System.out.println("connect error");
		}
		return null;

	}
}
