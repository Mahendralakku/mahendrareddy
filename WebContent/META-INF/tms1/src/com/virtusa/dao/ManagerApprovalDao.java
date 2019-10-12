package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.virtusa.bean.ManagerApprovalBean;

public class ManagerApprovalDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public ArrayList<ManagerApprovalBean> getNominationDetails() {
		ArrayList<ManagerApprovalBean> mAList = new ArrayList<>();
		Statement stmt = null;
		try {
			Connection con = ManagerApprovalDao.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * from nominationDetails where status='1'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ManagerApprovalBean mab = new ManagerApprovalBean();

				mab.setId(rs.getInt("id"));
				mab.setName(rs.getString("name"));
				mab.setTrainingId(rs.getInt("trainingid"));
				mab.setTrainingName(rs.getString("trainingname"));
				mab.setApplyDate(rs.getString("applyDate"));

				mAList.add(mab);
			}

		} catch (Exception e) {
			// System.out.println("getAllRoles()");
			e.printStackTrace();
		}

		return (mAList);
	}

	public boolean saveStatusOfNominationDao(String[] selectedItems, String status) {

		int a1 = 0;
		if (status.equals("Approve")) {
			a1 = 2;
		} else {
			a1 = 3;
		}
		boolean b1 = false;
		int a = 0, b = 0;
		try {
			Connection con = ManagerApprovalDao.getConnection();
			for (int i = 0; i < selectedItems.length; i++) {
				PreparedStatement ps = con.prepareStatement("update nominationdetails set status=? where id=?");
				ps.setInt(1, a1);
				ps.setInt(2, Integer.parseInt(selectedItems[i]));
				b = ps.executeUpdate();
			}
			b1 = true;
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b1;
	}
}
