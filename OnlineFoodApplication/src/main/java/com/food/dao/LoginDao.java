package com.food.dao;

public interface LoginDao {
	public boolean checkCustomer(String username,String password);
	public boolean checkAdmin(String username,String password);
	public boolean changeCustomerPassword(String username,String oldpassword,String newPassword);
	public boolean changeAdminPassword(String username,String oldpassword,String newPassword);

	

}
