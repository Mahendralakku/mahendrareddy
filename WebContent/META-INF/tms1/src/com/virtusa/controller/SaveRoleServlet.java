package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.bean.RoleBean;
import com.virtusa.dao.RegisterDao;
import com.virtusa.dao.RoleDao;


@WebServlet("/SaveRoleServlet")
public class SaveRoleServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String roleName=request.getParameter("roleName");
		String roleDesc=request.getParameter("roleDesc");
		System.out.println(roleName);
		
		RoleBean rb=new RoleBean();
		rb.setRoleName(roleName);
		rb.setRoleDescription(roleDesc);
		
		if(RoleDao.saveRoles(rb)) {
			 RequestDispatcher rd=request.getRequestDispatcher("SaveRoleServlet2");  
		     rd.forward(request,response);  
		}else {
			 pw.print("Sorry role details not inserted");  
			
			 RequestDispatcher rd=request.getRequestDispatcher("role.jsp");
			 rd.include(request,response);
			   
		}
	}

}
