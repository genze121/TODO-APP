package com.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.entity.User;
import com.todo.model.LoginDAO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginDAO loginDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		loginDAO = new LoginDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("email_");
		String password = request.getParameter("password_");

		User user = loginDAO.loginUser(username, password);
		HttpSession session = request.getSession();
		if (user != null) {
			System.out.println("User is available:- " + user);
			session.setAttribute("user", user);
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("User is not available:- " + user);
			session.setAttribute("ErrorMssg", "Something went wrong.Please try again....");
			response.sendRedirect("login.jsp");
		}

	}

}
