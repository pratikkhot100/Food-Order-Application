package com.food.pojo;

public class Food {
	private Integer foodId;
	private String fname;
	private String type;//veg or non veg
    private Double price;
    private Integer quantity;
    private String category;
    private String description;
    private Integer rating;
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	//it will create a food object all the values from foodid to rating
	public Food(Integer foodId, String fname, String type, Double price, Integer quantity, String category,
			String description, Integer rating) {
		super();
		this.foodId = foodId;
		this.fname = fname;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.description = description;
		this.rating = rating;
	}
	
	public Food(String fname, String type, Double price, Integer quantity, String category, String description,
			Integer rating) {
		super();
		this.fname = fname;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.description = description;
		this.rating = rating;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", fname=" + fname + ", type=" + type + ", price=" + price + ", quantity="
				+ quantity + ", category=" + category + ", description=" + description + ", rating=" + rating + "]";
	}
    
	
    
}
