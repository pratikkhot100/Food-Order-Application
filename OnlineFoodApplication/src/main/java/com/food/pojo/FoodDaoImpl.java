package com.food.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import com.food.dao.FoodDao;
import com.food.test.FoodTest;
import com.food.utility.DBConnection;

import java.sql.*
;
public class FoodDaoImpl implements FoodDao{
	
   Connection con=null;
   String sql=null;
   PreparedStatement ps=null;
   ResultSet rs=null;
   Food f=null;
   List<Food> flist=null;
	
	@Override
	public boolean addFood(Food f) {
		try {
			con=DBConnection.makeConnection();
			
			sql="insert into Food_Pratik(fname,type,price,quantity,category,description,rating)"+
			"values(?, ?, ?, ?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, f.getFname());
			ps.setString(2, f.getType());
			ps.setDouble(3, f.getPrice());
			ps.setInt(4, f.getQuantity());
			ps.setString(5, f.getCategory());
			ps.setString(6, f.getDescription());
			ps.setInt(7, f.getRating());
			int i=ps.executeUpdate();
			if (i>0) {
				return true;
			}
		
		} catch (Exception e)
		{
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
		
		return false;
	}

	@Override
	public boolean updateFood(Food f) {
		con=DBConnection.makeConnection();
		sql="update Food_Pratik set fname=?, type=?, price=?, quantity=?, category=?, description=?, rating=? where food_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, f.getFname());
			ps.setString(2, f.getType());
			ps.setDouble(3, f.getPrice());
			ps.setInt(4, f.getQuantity());
			ps.setString(5, f.getCategory());
			ps.setString(6, f.getDescription());
			ps.setInt(7, f.getRating());
			ps.setInt(8, f.getFoodId());
			
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
	public boolean deleteFood(Integer foodId) {
		
		con=DBConnection.makeConnection();
		sql="delete from Food_Pratik where food_id=? ";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, foodId);
			int i=ps.executeUpdate();
			if (i>0) {
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Food> searchFoodByCategory(String category) {
		con=DBConnection.makeConnection();
		sql="select * from Food_Pratik where category like ?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+category+"%");
			rs=ps.executeQuery();
			flist=new ArrayList<>();
			while (rs.next()) {
				f=new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				flist.add(f);
			}
			return flist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> searchFoodByName(String fname) {
		con=DBConnection.makeConnection();
		sql="select * from Food_Pratik where fname like ?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+fname+"%");
			rs=ps.executeQuery();
			flist=new ArrayList<>();
			while (rs.next()) {
				f=new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				flist.add(f);
			}
			return flist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Food searchFoodById(Integer foodId) {
		
		con=DBConnection.makeConnection();
		sql="select * from Food_Pratik where food_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, foodId);
			
			//System.out.println("query for searching by id= "+ps);
			rs=ps.executeQuery();
			if (rs.next()) {
				f=new Food();
				
				f.setCategory(rs.getString("category"));
				f.setDescription(rs.getString("description"));
				f.setFname(rs.getString("fname"));
				f.setFoodId(rs.getInt("foodId"));
				f.setPrice(rs.getDouble("price"));
				f.setQuantity(rs.getInt("quantity"));
				f.setRating(rs.getInt("rating"));
				f.setType(rs.getString("type"));
				return f;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Food> searchFoodByType(String type) {
		con=DBConnection.makeConnection();
		sql="select * from Food_Pratik where type=?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, type);
			rs=ps.executeQuery();
			flist=new ArrayList<>();
			while (rs.next()) {
				f=new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				flist.add(f);
			}
			return flist;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Food> fetchAllFood() {
		try {
			con=DBConnection.makeConnection();
			sql="select * from Food_Pratik order by fname";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			flist=new ArrayList<>();
			while (rs.next()) {
				f=new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				flist.add(f);
			}
			return flist;
		} 
		catch (Exception e) {
			// TODO: handle exception
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
	public void updateFoodQuantity(Integer foodId,Integer cartQuantity) {
		con=DBConnection.makeConnection();
		sql="update Food_Pratik set quantity=(quantity-?) where food_id=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cartQuantity);
			ps.setInt(2, foodId);
			
			int i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		
	}

}
