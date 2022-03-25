package com.simplilearn.webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.webapp.util.DbConnection;

@WebServlet("/init-connection")
public class InitializeDbConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// add nav bar
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		try {
			// create a db connection
			DbConnection dbConnection = new DbConnection();
			Connection connection = dbConnection.getConnection();
			if(connection!=null) {
				out.print("<h3 style='color:green'> Your DB connection successfully initiated !<h3>");
			} else {
				out.print("<h3 style='color:red'> Sorry, DB connection failed ! <h3>");
			}
		} catch (Exception e) {
			out.print("<h3 style='color:red'> Sorry, DB connection failed ! <h3>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
