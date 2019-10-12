package com.virtusa.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.bean.TrainingBean;
import com.virtusa.bo.SaveScheduleTrainingBo;
import com.virtusa.dao.TrainingRoleMappingDao;


@WebServlet("/saveScheduleTrainnigServlet")
public class saveScheduleTrainnigServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList al=null;
		ArrayList al1=null;
		
	    al=SaveScheduleTrainingBo.getTrainingsForSchedule();
	    al1=SaveScheduleTrainingBo.getVenuesForSchedule();
	   
         request.setAttribute("trainingsList", al);
         request.setAttribute("venuesList", al1);
	
	     request.getRequestDispatcher("/scheduleTraining.jsp").forward(request,response);
		
	}

}
