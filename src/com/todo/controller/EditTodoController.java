package com.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.entity.Todo;
import com.todo.model.TodoDAO;

/**
 * Servlet implementation class EditTodoController
 */
@WebServlet("/editTodo")
public class EditTodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TodoDAO todoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditTodoController() {
		super();
		todoDAO = new TodoDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int todoId = Integer.parseInt(request.getParameter("todoId"));
		String title = request.getParameter("title");
		boolean status = Boolean.valueOf(request.getParameter("status"));
		String username = request.getParameter("email_");
		String description = request.getParameter("description");
		int userId = Integer.parseInt(request.getParameter("userId"));

		Todo todo = new Todo(todoId, title, status, username, description, userId);

		boolean finalUpdated = todoDAO.updateTodo(todo);
		HttpSession session = request.getSession();
		if (finalUpdated) {
			System.out.println("Todo Notes is available:- " + todo);
			session.setAttribute("successMessage", "Updated Successfully....");
			response.sendRedirect("viewTodo.jsp");
		} else {
			System.out.println("Todo Notes is available:- " + todo);
			session.setAttribute("errorMessage", "Something went wrong.Please try again....");
			response.sendRedirect("editTodo.jsp?todoId=" + todoId);
		}
	}

}
