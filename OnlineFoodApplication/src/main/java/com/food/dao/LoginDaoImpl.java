package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.food.pojo.Food;
import com.food.utility.DBConnection;

public class LoginDaoImpl implements LoginDao {
	Connection con=null;
	   String sql=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	  

	@Override
	public boolean checkCustomer(String username, String password) {
		// TODO Auto-generated method stub
		
		con=DBConnection.makeConnection();
		sql="select * from Customer_Pratik where email=? && password=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean checkAdmin(String username, String password) {
		// TODO Auto-generated method stub
		con=DBConnection.makeConnection();
		sql="select * from Admin_Pratik where adminEmail=? && adminPassword=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean changeCustomerPassword(String username, String oldpassword, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeAdminPassword(String username, String oldpassword, String newPassword) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
