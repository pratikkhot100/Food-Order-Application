package com.food.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.pojo.Order;
import com.food.utility.DBConnection;

public class OrderDaoImpl implements OrderDao{
	Connection con=null;
	   String sql=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   List<Order> olist;
	   Order o;

	@Override
	public Order placeOrder(Order o) {
		con=DBConnection.makeConnection();
		sql="insert into Order_Pratik(billingAmount, orderDate, email, dropLocation, deliveryDate, status) "
				+ "values(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setDouble(1, o.getBillingAmount());
			ps.setDate(2, Date.valueOf(o.getOrderDate()));
			ps.setString(3, o.getEmail());
			ps.setString(4, o.getDropLocation());
			ps.setTimestamp(5, Timestamp.valueOf(o.getDeliveryDate()));
			ps.setString(6, o.getStatus());
			int i=ps.executeUpdate();
			if (i>0) {
				rs=ps.getGeneratedKeys();
				if (rs.next()) {
					int orderId=rs.getInt(1);
					o=searchOrderById(orderId);
					
					return o;
					
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean cancelOrder(Integer orderId) {
		con=DBConnection.makeConnection();
		sql="update   Order_Pratik set status='Cancelled' where orderId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			
			int i=ps.executeUpdate();
			if (i>0) {
				return true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public String checkStatus(Integer orderId) {
		con=DBConnection.makeConnection();
		sql="select status from Order_Pratik where orderId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			
			rs=ps.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public boolean changeStatus(Integer orderId, String status) {
		con=DBConnection.makeConnection();
		sql="update  Order_Pratik set status=? where orderId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, orderId);
			
			int i=ps.executeUpdate();
			if (i>0) {
				return true;
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return false;
	}

	@Override
	public List<Order> showOrderHistory(String email) {
		con=DBConnection.makeConnection();
		sql="select * from Order_Pratik where email=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			
			//System.out.println("ps in the my history\n"+ps);
			rs=ps.executeQuery();
			olist=new ArrayList<>();
			
			while (rs.next()) {
				o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setBillingAmount(rs.getDouble(2));
				o.setOrderDate(rs.getDate(3).toLocalDate());
				o.setEmail(rs.getString(4));
				o.setDropLocation(rs.getString(5));
				o.setDeliveryDate(rs.getTimestamp(6).toLocalDateTime());
				o.setStatus(rs.getString(7));
				olist.add(o);
			}
			return olist;
		} catch (Exception e) {
			e.printStackTrace();
		}
         finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Order> showAllOrders() {
		con=DBConnection.makeConnection();
		sql="select * from Order_Pratik";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			olist=new ArrayList<>();
			while (rs.next()) {
				o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setBillingAmount(rs.getDouble(2));
				o.setOrderDate(rs.getDate(3).toLocalDate());
				o.setEmail(rs.getString(4));
				o.setDropLocation(rs.getString(5));
				o.setDeliveryDate(rs.getTimestamp(6).toLocalDateTime());
				o.setStatus(rs.getString(7));
				olist.add(o);
				
			}
			return olist;
		} catch (Exception e) {
			e.printStackTrace();
		}
           finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}
	public Order searchOrderById(Integer orderId) {
		con=DBConnection.makeConnection();
		sql="select * from Order_Pratik where orderId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs=ps.executeQuery();
			if (rs.next()) {
				
				o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setBillingAmount(rs.getDouble(2));
				o.setOrderDate(rs.getDate(3).toLocalDate());
				o.setEmail(rs.getString(4));
				o.setDropLocation(rs.getString(5));
				o.setDeliveryDate(rs.getTimestamp(6).toLocalDateTime());
				o.setStatus(rs.getString(7));
				
				return o;
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
         finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
		
	}

}
