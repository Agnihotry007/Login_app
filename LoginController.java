package com.sagnik.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		HttpSession session = request.getSession();
		if (action != null && action.equals("logout")) {
			session.invalidate();
			response.sendRedirect("public?page=home");
		} else if (session.getAttribute("username") != null) {
			response.sendRedirect("private?page=home");
		} else {
			request.setAttribute("headerFile", "header.jsp");
			request.setAttribute("body", "login.jsp");
			request.setAttribute("title", "Login");
			request.getRequestDispatcher("template.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("Sagnik") && password.equals("1234")) {
			request.getSession().invalidate();
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);

			response.sendRedirect("private?page=home");
		} else {
			response.sendRedirect("login");
		}
	}

}
