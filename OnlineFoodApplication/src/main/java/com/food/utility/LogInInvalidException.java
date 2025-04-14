package com.food.utility;

import com.food.pojo.Food;



public class LogInInvalidException extends Exception  {
	
	@Override
	public String getMessage() {
		return "InvalidException";
	}
	@Override
	public String toString() {
		return "com.food.utility.InvalidException.Logincredential";
	}
}
