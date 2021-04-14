package com.todo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todo.connection.DBConnectionProvider;
import com.todo.entity.Todo;

public class TodoDAO {

	// ===========================================================================================//

	// 1) DEFINING THE QUERY FOR ADDING THE TODO NOTES

	// ===========================================================================================//

	private static final String INSERT_TODO = "insert into todo" + "(title,is_done,username,description,userid)"
			+ "values(?,?,?,?,?)";

	private static final String SELECT_LIST = "select * from todo where userid=?";

	private static final String SELECT_BY_ID = "select * from todo where id=?";

	private static final String UPDATE_EDIT = "update todo set title=?,is_done=?,username=?,description=? where id=?";

	private static final String DELETE = "delete from todo where id=?";

	// ===========================================================================================//

	// DATABASE LOGIC FOR REGISTERING THE USER INFORMATION

	// ===========================================================================================//

	public boolean addTodo(Todo todo) {

		boolean addCheck = false;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(INSERT_TODO);

			preparedstatement.setString(1, todo.getTitle());
			preparedstatement.setBoolean(2, todo.isStatus());
			preparedstatement.setString(3, todo.getUsername());
			preparedstatement.setString(4, todo.getDescription());
			preparedstatement.setInt(5, todo.getUserId());

			int todoAdded = preparedstatement.executeUpdate();

			if (todoAdded < 0 || todoAdded != 0) {
				addCheck = true;
				System.out.println("Notes added successfully.....");
			} else if (todoAdded > 0 || todoAdded == 1) {
				addCheck = true;
				System.out.println("Notes added successfully.....");
			} else {
				System.out.println("Something went wrong on the server.Please rectify and try again...");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return addCheck;
	}

	// ===========================================================================================//

	public List<Todo> getAllTodos(int uid) {

		List<Todo> lists = new ArrayList<Todo>();
		Todo todos = null;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(SELECT_LIST);
			System.out.println(preparedstatement);

			preparedstatement.setInt(1, uid);
			resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {
				todos = new Todo();
				todos.setId(resultSet.getInt(1));
				todos.setTitle(resultSet.getString(2));
				todos.setStatus(resultSet.getBoolean(3));
				todos.setUsername(resultSet.getString(4));
				todos.setDescription(resultSet.getString(5));
				todos.setUserId(resultSet.getInt(6));
				lists.add(todos);
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return lists;
	}

	// ===========================================================================================//

	public Todo getTodosById(int todoId) {

		Todo todos = null;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(SELECT_BY_ID);
			System.out.println(preparedstatement);

			preparedstatement.setInt(1, todoId);
			resultSet = preparedstatement.executeQuery();

			while (resultSet.next()) {
				todos = new Todo();
				todos.setId(resultSet.getInt(1));
				todos.setTitle(resultSet.getString(2));
				todos.setStatus(resultSet.getBoolean(3));
				todos.setUsername(resultSet.getString(4));
				todos.setDescription(resultSet.getString(5));
				todos.setUserId(resultSet.getInt(6));
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return todos;
	}

	public boolean updateTodo(Todo todo) {

		boolean updateCheck = false;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(UPDATE_EDIT);

			preparedstatement.setString(1, todo.getTitle());
			preparedstatement.setBoolean(2, todo.isStatus());
			preparedstatement.setString(3, todo.getUsername());
			preparedstatement.setString(4, todo.getDescription());
			preparedstatement.setInt(5, todo.getId());

			int todoUpdated = preparedstatement.executeUpdate();

			if (todoUpdated < 0 || todoUpdated != 0) {
				updateCheck = true;
				System.out.println("Notes updated successfully.....");
			} else if (todoUpdated > 0 || todoUpdated == 1) {
				updateCheck = true;
				System.out.println("Notes updated successfully.....");
			} else {
				System.out.println("Something went wrong on the server.Please rectify and try again...");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return updateCheck;
	}

	public boolean deleteTodo(int todoId) {

		boolean deleteCheck = false;
		PreparedStatement preparedstatement = null;
		Connection connection = null;
		try {
			connection = DBConnectionProvider.getConnection();
			preparedstatement = connection.prepareStatement(DELETE);

			preparedstatement.setInt(1, todoId);

			int tododeleted = preparedstatement.executeUpdate();

			if (tododeleted < 0 || tododeleted != 0) {
				deleteCheck = true;
				System.out.println("Notes deleted successfully.....");
			} else if (tododeleted > 0 || tododeleted == 1) {
				deleteCheck = true;
				System.out.println("Notes deleted successfully.....");
			} else {
				System.out.println("Something went wrong on the server.Please rectify and try again...");
			}
		} catch (SQLException ex) {
			DBConnectionProvider.printSQLException(ex);
		}

		return deleteCheck;
	}
}
