package com.virtusa.bo;

import java.util.ArrayList;

import com.virtusa.bean.TrainingBean;
import com.virtusa.dao.SaveNominationDao;

public class SaveNominationBo {

	public static ArrayList<TrainingBean> getTrainingsBasedOnRoleId(String s1) {
	
	 ArrayList<TrainingBean> tb=null;
	 tb=SaveNominationDao.getTrainingsBasedOnRoleId(s1);
	 
	 return tb;
		
	}

	public static boolean saveNominationDetails(String fname, String lname, String trainingId, String applyDate) {
		// TODO Auto-generated method stub
		boolean b=false;
		
		b=SaveNominationDao.saveNominationDetails(fname,lname,trainingId,applyDate);
		
		return b;
	}

	
	
}
