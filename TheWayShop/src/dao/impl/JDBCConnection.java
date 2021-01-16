package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	public static void main(String[] args) {
		JDBCConnection userConnection = new JDBCConnection();
		Connection connection = userConnection.getConnection();

		if (connection == null) {
			System.out.println("Ket noi that bai");
		} else {
			System.out.println("ket noi thanh cong");
		}
	}

	public static Connection getConnection() {
		try {
			String username = "root";
			String password = "truong96";
			String url = "jdbc:mysql://localhost:3306/thewayshop";
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (Exception e) {
			System.out.println("Loi" + e);
		}
		return null;
	}
}
