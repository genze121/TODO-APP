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
 * Servlet implementation class AddController
 */
@WebServlet("/addTodo")
public class AddTodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TodoDAO todoDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTodoController() {
		super();
		todoDAO = new TodoDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		boolean status = Boolean.valueOf(request.getParameter("status"));
		String username = request.getParameter("email_");
		String description = request.getParameter("description");
		int userId = Integer.parseInt(request.getParameter("userId"));

		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setStatus(status);
		todo.setUsername(username);
		todo.setDescription(description);
		todo.setUserId(userId);

		boolean finalTodo = todoDAO.addTodo(todo);
		HttpSession session = request.getSession();
		if (finalTodo) {
			session.setAttribute("SuccessMssg", "Todo notes added successfully....");
			response.sendRedirect("addTodo.jsp");
		} else {
			session.setAttribute("ErrorMssg", "Something went wrong on the server.Please try again....");
			response.sendRedirect("addTodo.jsp");
		}
	}

}
