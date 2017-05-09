package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
	private static Connection connection;
	public static String STAG = "4szaixian_";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("--DBConenect--static err");
		}
		System.out.println("--DBConenect--static ok");
	}

	public static Connection getConnection() {
		// String
		// url="jdbc:mysql://sqld.duapp.com:4050/qKxxiKJeZWtCaidkPwXM?useUnicode=true&characterEncoding=UTF8";
		// String user="D777e076494a169f31496573a927f4b5";
		// String password="2dac22a08bdf44aedcd0d6c93b98c402";

		String url = "jdbc:mysql://127.0.0.1:3306/gudong?useUnicode=true&characterEncoding=UTF8&useSSL=false";
		String user = "root";
		try {
			connection = DriverManager.getConnection(url, user, DBConfig.PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("--DBConenect--static getConnection�쳣");
			return null;
		}
		return connection;
	}
}
