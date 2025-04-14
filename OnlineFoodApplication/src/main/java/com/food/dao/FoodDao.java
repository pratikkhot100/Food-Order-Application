package com.food.dao;

import java.util.List;

import com.food.pojo.Food;

public interface FoodDao {
	public boolean addFood(Food f);
	public boolean updateFood(Food f);
	public boolean deleteFood(Integer foodId);
	
	public List<Food> searchFoodByCategory(String category);
	public List<Food> searchFoodByName(String fname);
	public Food searchFoodById(Integer foodId);
	public List<Food> searchFoodByType(String type);
	public List<Food> fetchAllFood();
	
	
	
	

}
