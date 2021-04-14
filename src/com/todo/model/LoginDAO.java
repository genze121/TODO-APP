package com.todo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.todo.connection.DBConnectionProvider;
import com.todo.entity.User;

public class LoginDAO {

	// ===========================================================================================//

	// DEFINING THE QUERY FOR LOGIN

	// ===========================================================================================//

	private static final String SELECT_LOGIN = "select * from register_login where username=? and password=?";

	// ===========================================================================================//

	// DATABASE LOGIC FOR LOGIN

	// ===========================================================================================//

	public User loginUser(String username, String password) {

		User user = null;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(SELECT_LOGIN);

			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);

			resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt(1));
				user.setFirstname(resultSet.getString(2));
				user.setLastname(resultSet.getString(3));
				user.setUsername(resultSet.getString(4));
				user.setPassword(resultSet.getString(5));
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return user;
	}

	// ===========================================================================================//

}
