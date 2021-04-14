package com.todo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.todo.entity.User;
import com.todo.model.RegisterDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RegisterDAO registerDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
		super();
		registerDAO = new RegisterDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ===========================================================================================//

		// BUSINESS LOGIC FOR REGISTERING THE USER INFORMATION

		// ===========================================================================================//

		HttpSession session = request.getSession();

		String checkBox = request.getParameter("checkbox");

		if (checkBox == null) {
			session.setAttribute("CheckboxMssg", "Please fill all the details to register the user information...");
			response.sendRedirect("register.jsp");
			System.out.println();
		} else {
			String firstname = request.getParameter("first_name");
			String lastname = request.getParameter("last_name");
			String username = request.getParameter("email_");
			String password = request.getParameter("password_");

			User user = new User();
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setUsername(username);
			user.setPassword(password);

			boolean finalRegister = registerDAO.registerUser(user);
			if (finalRegister) {
				session.setAttribute("SuccessMssg", "User is registered successfully......");
				response.sendRedirect("register.jsp");
			} else {
				session.setAttribute("ErrorMssg", "Something went wrong.Please try again......");
				response.sendRedirect("register.jsp");
			}
		}
	}

}
