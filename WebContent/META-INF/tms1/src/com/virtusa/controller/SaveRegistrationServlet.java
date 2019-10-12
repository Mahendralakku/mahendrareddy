package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.bean.EmployeeBean;
import com.virtusa.dao.RegisterDao;


@WebServlet("/SaveRegistrationServlet")
public class SaveRegistrationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
		 PrintWriter pw = response.getWriter();  
		    
	    String fname=request.getParameter("userFirstname");
		String lname=request.getParameter("userLastname");
		String email=request.getParameter("userEmail");
		String dob=request.getParameter("userDOB");
		String address=request.getParameter("userAddress");
		String username=request.getParameter("userName");
		String password=request.getParameter("userPassword");
		String confirmPW=request.getParameter("userConfirmPW");
		String userType=request.getParameter("userType");
		//String hiddenId=request.getParameter("adminId");
		
		if(password.equals(confirmPW)) {
			EmployeeBean eb=new EmployeeBean();
			eb.setFirstName(fname);
			eb.setLastName(lname);
			eb.setEmail(email);
			eb.setDob(dob);
			eb.setAddress(address);
			eb.setUserName(username);
			eb.setPassword(password);
			eb.setConfirmPW(confirmPW);
			eb.setHiddenId(userType);
			
			if(RegisterDao.save(eb)) {
				RequestDispatcher rd=request.getRequestDispatcher("SaveRegistrationServlet2");  
			    rd.forward(request,response);  
			}else {
				 pw.print("Sorry username or password error");  
			     RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");  
			     rd.include(request,response);  
			}
			
		}else {
			pw.println("Password and Confirm Passsword should be same");
			RequestDispatcher rd=request.getRequestDispatcher("adminRegistration.jsp");  
		     rd.include(request,response);  

		}
		
		
	}

}
