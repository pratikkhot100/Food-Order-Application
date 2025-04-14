package com.food.dao;

import java.util.List;

import com.food.pojo.Cart;

public interface CartDao {
	public boolean  addToCart(Cart c);
	public boolean deleteCartItem(Integer cartId);
	public boolean updateQuantity(Integer CartId,Integer quantity);
	public boolean clearMyCard(String email);
	
	
	public List<Cart> showMyCart(String email);
	public List<Cart> showAllCard();
	
	
	

}
