package com.todo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.todo.connection.DBConnectionProvider;
import com.todo.entity.User;

public class RegisterDAO {

	// ===========================================================================================//

	// DEFINING THE QUERY FOR REGISTERING THE USER INFORMATION

	// ===========================================================================================//

	private static final String INSERT_REGISTER = "insert into register_login"
			+ "(firstname,lastname,username,password)" + "values(?,?,?,?)";

	// ===========================================================================================//

	// DATABASE LOGIC FOR REGISTERING THE USER INFORMATION

	// ===========================================================================================//

	public boolean registerUser(User user) {

		boolean registerCheck = false;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(INSERT_REGISTER);

			preparedstatement.setString(1, user.getFirstname());
			preparedstatement.setString(2, user.getLastname());
			preparedstatement.setString(3, user.getUsername());
			preparedstatement.setString(4, user.getPassword());

			int registered = preparedstatement.executeUpdate();

			if (registered < 0 || registered != 0) {
				registerCheck = true;
				System.out.println("User is registered successfully.....");
			} else if (registered > 0 || registered == 1) {
				registerCheck = true;
				System.out.println("User is registered successfully.....");
			} else {
				System.out.println("Something went wrong on the server.Please rectify and try again...");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return registerCheck;
	}

	// ===========================================================================================//

}
