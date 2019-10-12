package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.virtusa.bean.RoleBean;
import com.virtusa.bean.TrainingBean;

public class SaveNominationDao {
	
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


	public static ArrayList<TrainingBean> getTrainingsBasedOnRoleId(String s1) {
		
		ArrayList<TrainingBean> tb=new ArrayList<TrainingBean>();
		
		  int roleId1=Integer.parseInt(s1.substring(0,1));
		
		 Statement stmt = null;
		// ArrayList trainindIds =new ArrayList();
		   try {
		    	Connection con=TrainingRoleMappingDao.getConnection();
		    	
		    	PreparedStatement ps=con.prepareStatement("SELECT t.trainingId,t.trainingName,t.trainingType,t.trainingDesc from roletrainingmappingdetails r inner join trainingdetails t on r.trainingid = t.trainingid where r.roleid=?");
			    ps.setInt(1, roleId1);

		    	
		    	
		    	 // stmt = con.createStatement();
		    	
		       // String sql = "SELECT t.trainingId,t.trainingName,t.trainingType,t.trainingDesc from roletrainingmappingdetails r inner join trainingdetails t on r.trainingid = t.trainingid where r.roleid=2";
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		        	TrainingBean tb1 = new TrainingBean();
                    tb1.setTrainingId(rs.getInt("trainingid"));
		            tb1.setTrainingName(rs.getString("trainingName"));
		            tb1.setTrainingType(rs.getString("trainingType"));
		            tb1.setTrainingDesc(rs.getString("trainingDesc"));
		            tb.add(tb1);
		            }

		    } catch (Exception e) {
		        //System.out.println("getAllTrainings()");
		        e.printStackTrace();
		    }
		return tb;
	}


	public static boolean saveNominationDetails(String fname, String lname, String trainingId, String applyDate) {
		
		int trainingId1=Integer.parseInt(trainingId.substring(0, 1));
		String trainingName1=trainingId.substring(1);
		boolean b=false;
		int status=0;
		int a=1;
		try{
			Connection con=RoleDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into nominationDetails(id,name,trainingId,trainingName,applydate,status) values (?,?,?,?,?,?)");
		    ps.setInt(1, getId());
			ps.setString(2,(fname+" "+lname));
			ps.setInt(3,trainingId1);
			ps.setString(4, trainingName1);
		    ps.setString(5, applyDate);	
		    ps.setInt(6, a);
		
			status=ps.executeUpdate();
			b=true;
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
	   }
		
		
		
	
		return false;
	}
	
  public static int getId() {
		 int id=0;
     try {
	    Connection con=RegisterDao.getConnection();
	    PreparedStatement ps=con.prepareStatement("select count(*) from nominationDetails");
	     ResultSet rs=ps.executeQuery();
	    if(rs.next()) {
		  id=rs.getInt(1)+1;
		}else {
		  id=id+1;
	       }
	    } catch (Exception e) {
			e.printStackTrace();
	  }
	    return id;
	}
	
	
	
	
	
	
	
	
	}

