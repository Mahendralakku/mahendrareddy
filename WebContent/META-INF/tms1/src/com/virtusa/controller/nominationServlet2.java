package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class nominationServlet1
 */
@WebServlet("/nominationServlet2")
public class nominationServlet2 extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			 response.setContentType("text/html");  
			    PrintWriter pw = response.getWriter();  
			          
			    pw.println("nomination details Inserted Successfully");
			
	}

	

}
