package com.food.dao;

import java.util.List;

import com.food.pojo.Customer;

public interface CustomerDao {
	public boolean addCustomer(Customer c);
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(Integer cusId);
	
	public Customer searchCustomerById(Integer cusId);
	public List<Customer> seachAllCustomer();
	
	public List<Customer> searchCustomerByName(String cname);
	public Customer searchCustomerByEmail(String email);
	public boolean uniequeEmail(String email);
	public boolean uniquePassword(String password);
	
	
	

}
