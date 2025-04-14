package com.food.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.food.pojo.Cart;
import com.food.pojo.Food;
import com.food.pojo.FoodDaoImpl;
import com.food.utility.DBConnection;

public class CardDaoImpl  implements CartDao{
	Connection con=null;
	   String sql=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   
	   List<Cart> clist=null;
	   Cart c=null;

	@Override
	public boolean addToCart(Cart c) {
		// TODO Auto-generated method stub
		con=DBConnection.makeConnection();
		sql="insert into Cart_Pratik(food_id,quantity,price,subtotal,email) values"
		+"(?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, c.getFoodId());
			ps.setInt(2, c.getQuantity());
			ps.setDouble(3, c.getPrice());
			ps.setDouble(4, c.getSubtotal());
			ps.setString(5, c.getEmail());
			
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
	public boolean deleteCartItem(Integer cartId) {
		con=DBConnection.makeConnection();
		sql="delete from Cart_Pratik  where cartId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cartId);
			
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
	public boolean updateQuantity(Integer CartId, Integer quantity) {
		con=DBConnection.makeConnection();
		sql="update Cart_Pratik set quantity=? where cartId=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, CartId);
			int i=ps.executeUpdate();
			if (i>0) {
				sql="update Cart_Pratik set subtotal=(price*quantity) where cartId=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, CartId);
				i=ps.executeUpdate();
				if (i>0) {
					
					return true;
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
		
		
		return false;
	}

	@Override
	public boolean clearMyCard(String email) {
		con=DBConnection.makeConnection();
		sql="delete from Cart_Pratik  where email=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
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
	public List<Cart> showMyCart(String email) {
		con=DBConnection.makeConnection();
		sql="select * from Cart_Pratik where email=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			clist=new ArrayList<>();
			while(rs.next())
			{
			c=new Cart();
			
			c.setCartId(rs.getInt("cartId"));
			c.setEmail(rs.getString("email"));
			c.setPrice(rs.getDouble("price"));

			int foodId=rs.getInt("food_id");
		    Food f=new FoodDaoImpl().searchFoodById(foodId);
		    c.setF(f);
		    
		    c.setFoodId(foodId);
		    c.setQuantity(rs.getInt("quantity"));
		    c.setSubtotal(rs.getDouble("subtotal"));
		   
			clist.add(c);
			}
			
			return clist;

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
	public List<Cart> showAllCard() {
		con=DBConnection.makeConnection();
		sql="select * from Cart_Pratik";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			clist=new ArrayList<>();
			while (rs.next()) {
				c=new Cart();
				c.setCartId(rs.getInt(1));
				c.setEmail(rs.getString("email"));
				
				int foodId=rs.getInt("food_id");
			    Food f=new FoodDaoImpl().searchFoodById(foodId);
			    c.setF(f);
			    c.setFoodId(foodId);
			    c.setQuantity(rs.getInt("quantity"));
			    
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
	
	public Map<Double,Double> fetchPriceSubtotal(Integer food_id,Integer quantity)
	{
		con=DBConnection.makeConnection();
		sql="select price from Food_Pratik where food_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, food_id);
			
			rs=ps.executeQuery();
			
			Map<Double,Double> m=new HashMap<>();
			
			if (rs.next()) {
				double price=rs.getDouble(1);
				double subtotal=price*quantity;
				m.put(price, subtotal);
				
				return m;
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
	
	public boolean checkCartItem(Integer food_id,String email) {
		con=DBConnection.makeConnection();
		sql="select * from Cart_Pratik where  food_id=? && email=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, food_id);
			ps.setString(2, email);
			rs=ps.executeQuery();
			if (rs.next()) {
				int cartId=rs.getInt("cartId");
				int quantity=rs.getInt("quantity");
				quantity+=1;
				
			return	updateQuantity(cartId,quantity);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        
		return false;
	}
	
}
