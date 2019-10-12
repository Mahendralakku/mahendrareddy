package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logOutServlet")
public class LogOutServlet extends HttpServlet {
	public LogOutServlet() {
        super();
    
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=response.getWriter();
		request.getSession().invalidate();
	   // HttpSession session1=request.getSession(false);
		
		//if(session1 != null) {
			//session1.removeAttribute("user");
			RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.forward(request,response);
		//  }
	   }
  }
