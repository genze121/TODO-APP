package com.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.model.TodoDAO;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TodoDAO todoDAO;

	public DeleteController() {
		super();
		todoDAO = new TodoDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int todoId = Integer.parseInt(request.getParameter("todoId"));

		boolean finalDelete = todoDAO.deleteTodo(todoId);
		HttpSession session = request.getSession();
		if (finalDelete) {
			session.setAttribute("successMessage", "Deleted Successfully.....");
			response.sendRedirect("viewTodo.jsp");
		} else {
			session.setAttribute("errorMessage", "Something went wrong.Please try again.....");
			response.sendRedirect("viewTodo.jsp");
		}
	}

}
