package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.virtusa.bean.RoleBean;

public class SaveScheduleTrainingDao {
	
	
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}


	public static ArrayList getTrainingsForSchedule() {
	
		   ArrayList al = new ArrayList();
		    Statement stmt = null;
		   try {
		    	Connection con=SaveScheduleTrainingDao.getConnection();
		    	 stmt = con.createStatement();
		        String sql = "SELECT * from nominationdetails where status='2'";

		        ResultSet rs = stmt.executeQuery(sql);
		        while (rs.next()) {
		        	al.add(rs.getString("trainingName"));
		            }

		    } catch (Exception e) {
		    
		        e.printStackTrace();
		    }

		 
		   return al;
	}


	public static ArrayList getVenuesForSchedule() {
		ArrayList al = new ArrayList();
		    Statement stmt = null;
		   try {
		    	Connection con=SaveScheduleTrainingDao.getConnection();
		    	 stmt = con.createStatement();
		        String sql = "SELECT * from venuedetails";

		        ResultSet rs = stmt.executeQuery(sql);
		        while (rs.next()) {
		        	al.add(rs.getString("venuename"));
		            }

		    } catch (Exception e) {
		    
		        e.printStackTrace();
		    }

		 
		   return al;
	}

}
