package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.bo.trainingAndRoleMappingBo;

/**
 * Servlet implementation class TrainingAndRoleMappingServlet2
 */
@WebServlet("/TrainingAndRoleMappingServlet2")
public class TrainingAndRoleMappingServlet2 extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			String s1=request.getParameter("roleIdFinal");
			String trainings[] = request.getParameterValues("item");
			//pw.println(Arrays.toString(hobbise1));
		
		boolean a=	trainingAndRoleMappingBo.trainingAndRoleMapping(s1,trainings);
		if(a) {
			 pw.print("Role-Trainings mapped Successfully");  
		    RequestDispatcher rd=request.getRequestDispatcher("trainingAndRoleMapping.jsp");
		    rd.include(request,response);
		}else {
			 pw.print("Role-Trainings Not mapped Successfully");  
			    RequestDispatcher rd=request.getRequestDispatcher("trainingAndRoleMapping.jsp");
			    rd.include(request,response);
		}
		
	}

}
