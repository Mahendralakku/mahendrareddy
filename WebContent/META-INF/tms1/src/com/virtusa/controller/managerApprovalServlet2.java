package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class managerApprovalServlet2
 */
@WebServlet("/managerApprovalServlet2")
public class managerApprovalServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
		    PrintWriter pw = response.getWriter();  
		          
		    pw.println("Nomination Status Details Inserted Successfully"); 
		
	}

	

}
