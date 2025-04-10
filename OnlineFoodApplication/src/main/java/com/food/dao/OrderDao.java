package com.food.dao;

import java.util.List;

import com.food.pojo.Order;
                                           
public interface OrderDao {
	public Order placeOrder(Order o);
	public boolean cancelOrder(Integer orderId);
	public String checkStatus(Integer orderId);
	public boolean changeStatus(Integer orderId,String status);
	
	public List<Order> showOrderHistory(String email);
	public List<Order> showAllOrders();

}
