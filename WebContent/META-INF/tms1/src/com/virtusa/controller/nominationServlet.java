package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.bean.RoleBean;
import com.virtusa.bean.TrainingBean;
import com.virtusa.bo.SaveNominationBo;
import com.virtusa.dao.TrainingRoleMappingDao;

/**
 * Servlet implementation class nominationServlet
 */
@WebServlet("/nominationServlet")
public class nominationServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		
		  ArrayList<RoleBean> rb=null;
		  ArrayList<TrainingBean> tb=null;
		  
		  //Nomination Submission
		     String fname=request.getParameter("fname");
		     String lname=request.getParameter("lname");
		     String trainingId=request.getParameter("trainingIdFinal");
		     String applyDate=request.getParameter("applyDate");
		
	     rb=TrainingRoleMappingDao.getAllRoles();
	     request.setAttribute("roleList", rb);
	    //	Trainings Retriving Based On RoleId     
	     String s1=request.getParameter("roleIdFinal");
	     if(s1!=null) {
	    tb=SaveNominationBo.getTrainingsBasedOnRoleId(s1);
	          request.setAttribute("trainingList", tb);
	       }
	    
	    
	    if(fname != null && lname != null && trainingId != null && applyDate!=null ) {
	    	 
	  	boolean b= SaveNominationBo.saveNominationDetails(fname,lname,trainingId,applyDate);
	    	if(b) {
	    		//pw.println("Nomination Details Inserted Successfully");
	    		request.getRequestDispatcher("nominationServlet2").forward(request,response);
	    	}else {
	    		//pw.println("Nomination Details Not Inserted Successfully");
	    		request.getRequestDispatcher("nominationServlet2").forward(request,response);
	    	}
	     }
	     
	     
		request.getRequestDispatcher("/nomination.jsp").forward(request,response);
		
		
     	}
	}
