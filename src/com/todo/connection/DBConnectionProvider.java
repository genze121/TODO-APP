package com.todo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {

	// ===========================================================================================//

	// DEFINING THE URL, USERNAME AND PASSWORD FOR MYSQL DB

	// ===========================================================================================//

	private static final String URL = "jdbc:mysql://localhost:3306/Todo_Notes_App";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	// ===========================================================================================//

	// LOADING AND REGISTERING THE MYSQL DRIVER

	// ===========================================================================================//

	private static String DRIVER;
	static {
		try {
			DRIVER = "com.mysql.cj.jdbc.Driver";
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ===========================================================================================//

	// ESTABLISHING THE CONNECTION BETWEEN THE BACK-END AND DB

	// ===========================================================================================//

	@SuppressWarnings("unused")
	public static Connection getConnection() {
		Connection connection = null;
		try {
			if (connection != null) {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connection is Established successfully...");
			} else if (connection == null) {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connection is Established successfully...");
			} else {
				System.out.println("Something went wrong on the server.Please rectify and try again....");
			}

		} catch (SQLException ex) {
			printSQLException(ex);
		}
		return connection;
	}

	// ===========================================================================================//

	// DEFINING THE GENERIC EXCEPTION

	// ===========================================================================================//

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.out.println("SQL State:- " + ((SQLException) e).getSQLState());
				System.out.println("Error Code:- " + ((SQLException) e).getErrorCode());
				System.out.println("Message:- " + ((SQLException) e).getMessage());
				Throwable thrown = ex.getCause();
				while (thrown != null) {
					thrown = thrown.getCause();
				}
			}
		}
	}

	// ===========================================================================================//

}
