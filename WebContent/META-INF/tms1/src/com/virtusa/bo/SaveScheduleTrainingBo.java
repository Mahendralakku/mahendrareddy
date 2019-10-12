package com.virtusa.bo;

import java.util.ArrayList;

import com.virtusa.dao.SaveScheduleTrainingDao;

public class SaveScheduleTrainingBo {

	public static ArrayList getTrainingsForSchedule() {
		
		
		ArrayList al=SaveScheduleTrainingDao.getTrainingsForSchedule();
		return al;
	}

	public static ArrayList getVenuesForSchedule() {

		ArrayList al1=SaveScheduleTrainingDao.getVenuesForSchedule();
		return al1;
	}

}
