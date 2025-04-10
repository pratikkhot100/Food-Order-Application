package com.food.utility;

import java.sql.*;

public class DBConnection {
	public static Connection makeConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/food_delivery?user=root&password=password");

			if (con != null) {
				return con;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
