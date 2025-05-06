package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.LoginDao;
import com.model.User;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginDao ld = new LoginDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("user");
		String password = request.getParameter("pwd");

		String result = null;
		PrintWriter out = response.getWriter();

		try {
			result = ld.checkLogin(userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result.equalsIgnoreCase("login Succesfully")) {
			User user = new User(userName, password);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("welcomePage.html");
			rd.forward(request, response);
		} else {
			out.write(result);
			RequestDispatcher rd = request.getRequestDispatcher("loginPage.html");
			rd.include(request, response);
		}

	}
}