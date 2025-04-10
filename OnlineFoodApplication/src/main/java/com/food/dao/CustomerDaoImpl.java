package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.food.pojo.Customer;
import com.food.pojo.Food;
import com.food.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao{

	   Connection con=null;
	   String sql=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   Customer f=null;
	   List<Customer> flist=null;
	   List<Customer> clist=null;
	  

	@Override
	public boolean addCustomer(Customer c) {
		try {
			con=DBConnection.makeConnection();
			
			sql="insert into Customer_Pratik(cname,address,email,contactNo,password) values(?, ?, ?, ?,?)";
			
			ps=con.prepareStatement(sql);
			ps.setString(1,c.getCname());
			ps.setString(2,c.getAddress());
			ps.setString(3, c.getEmail());
			ps.setLong(4, c.getContactNo());
			ps.setString(5, c.getPassword());
			
			int i=ps.executeUpdate();
			if (i>0) {
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		con=DBConnection.makeConnection();
		sql="update Customer_Pratik set cname=?,address=?,email=?,contactNo=? where cusId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getCname());
			ps.setString(2, c.getAddress());
			ps.setString(3, c.getEmail());
			ps.setLong(4, c.getContactNo());
			ps.setInt(5, c.getCusId());
			
			//System.out.println("ps in update customer= "+ps);
			int i=ps.executeUpdate();
			
			if (i>0) {
				return true;
			}
			con.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteCustomer(Integer cusId) {
		con=DBConnection.makeConnection();
		sql="delete from Customer_Pratik  where cusId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cusId);
			int i=ps.executeUpdate();
			if (i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer searchCustomerById(Integer cusId) {
		con=DBConnection.makeConnection();
		sql="select * from Customer_Pratik where cusId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cusId);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				f=new Customer();
				f.setAddress(rs.getString("address"));
				f.setCname(rs.getString("cname"));
				f.setContactNo(rs.getLong("contactNo"));
				f.setCusId(rs.getInt("cusId"));
				f.setEmail(rs.getString("email"));
				f.setPassword(rs.getString("password"));
				return f;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<Customer> seachAllCustomer() {
		con=DBConnection.makeConnection();
		sql="select * from Customer_Pratik";
		try {
	       ps=con.prepareStatement(sql);
	       rs=ps.executeQuery();
	       clist=new ArrayList<>();
	       
	       while (rs.next()) {
			f=new Customer();
			f.setAddress(rs.getString("address"));
		    f.setCname(rs.getString("cname"));
		    f.setContactNo(rs.getLong("contactNo"));
		    f.setCusId(rs.getInt("cusId"));
		    f.setEmail(rs.getString("email"));
		    f.setPassword(rs.getString("password"));
		    clist.add(f);
		}
	       return clist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Customer> searchCustomerByName(String cname) {
		con=DBConnection.makeConnection();
		sql="select * from Customer_Pratik where cname=?";
		try {
			ps=con.prepareStatement(sql);
			
		
			ps.setString(1, cname);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				f=new Customer();
				f.setCusId(rs.getInt("cusId"));
				f.setAddress(rs.getString("address"));
				f.setCname(rs.getString("cname"));
				f.setContactNo(rs.getLong("contactNo"));
				f.setPassword(rs.getString("password"));
				
				clist.add(f);
			}
			return clist;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer searchCustomerByEmail(String email) {
		con=DBConnection.makeConnection();
		sql="select * from Customer_Pratik where email=?";
		try {
			ps=con.prepareStatement(sql);
			
		
			ps.setString(1, email);
			//System.out.println(ps);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				f=new Customer();
				f.setCusId(rs.getInt("cusId"));
				f.setAddress(rs.getString("address"));
				f.setCname(rs.getString("cname"));
				f.setEmail(rs.getString("email"));
				f.setContactNo(rs.getLong("contactNo"));
				f.setPassword(rs.getString("password"));
				
              return f;
			}
			
		}
			catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return null;
	}

	@Override
	public boolean uniequeEmail(String email) {
		con=DBConnection.makeConnection();
		sql="select email from Customer_Pratik where email=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
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
	public boolean uniquePassword(String password) {
		con=DBConnection.makeConnection();
		sql="select password from Customer_Pratik where password=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, password);
			rs=ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
