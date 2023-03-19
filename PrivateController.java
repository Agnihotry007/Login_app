package com.sagnik.controllers;

import jakarta.servlet.ServletException;
/*import jakarta.servlet.annotation.WebServlet;*/
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PrivateController
 */
public class PrivateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrivateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		switch (page) {
		case "home":
			request.setAttribute("headerFile", "privateHeader.jsp");
			request.setAttribute("body", "home.jsp");
			request.setAttribute("title", "Private-Home");
			request.getRequestDispatcher("template.jsp").forward(request, response);
			break;

		case "dashboard":
			request.setAttribute("headerFile", "privateHeader.jsp");
			request.setAttribute("body", "dashboard.jsp");
			request.setAttribute("title", "Private-Dashboard");
			request.getRequestDispatcher("template.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
