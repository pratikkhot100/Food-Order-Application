package com.food.test;

import java.util.List;
import java.util.Scanner;

import com.food.dao.LoginDaoImpl;
import com.food.pojo.Food;
import com.food.pojo.FoodDaoImpl;
import com.food.utility.LogInInvalidException;

public class FoodTest {
	
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		Food f=null;
		FoodDaoImpl fimpl=new FoodDaoImpl();
		List<Food> flist=null;
		LoginDaoImpl limpl=new LoginDaoImpl();
		
		
		 Integer foodId;
		 String fname;
		 String type;//veg or non veg
	     Double price;
	     Integer quantity;
	     String category;
	     String description;
	     Integer rating;
	     Boolean flag;
	     
	     String login=null;
		System.out.println("-------------WELCOME-------------");
		System.out.print("Enter username: your Email id:");
		String username=sc.nextLine();
		
		System.out.println("Enter password:");
		String password=sc.nextLine();
		flag=limpl.checkAdmin(username, password);
		
		if (flag) {
			System.out.println("You have logged in as admin");
			login="admin";
		}
		else {
			flag=limpl.checkCustomer(username, password);
			if (flag) {
				System.out.println("You have logged in as Customer");
				login="customer";
			}
			else {
				System.out.println("The credentials are wrong. Try again.....");
				try{throw new LogInInvalidException();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				}
			}
			
		
		
		
		while (true) {
			if (login.equals("admin")) {
				
			
			System.out.println("Enter the number as given in option");
			System.out.println("Enter 1-->Add new Food Item");
			System.out.println("Enter 2-->Show food");
			System.out.println("Enter 3-->Update food");
			System.out.println("Enter 4-->Delete food Item");
			System.out.println("Enter 8-->Exit");

			}
			else if(login.equals("customer")) {
				System.out.println("\nEnter the number as given in option");
				System.out.println("Enter 2---->Show Menu");
				System.out.println("Enter 5---->Search food by category");
				
				System.out.println("Enter 6---->Search food by item");
				System.out.println("Enter 7---->search food item by type");
				
				System.out.println("Enter 8-->Exit");

			}
			else
			{
				System.out.println("Please login to continue....");
				break;
			}
			
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 1:
				System.out.print("Enter Name of the Item: ");
				fname=sc.nextLine();
				
				System.out.print("Enter type Veg or Non-Veg: ");
				type=sc.nextLine();
				
				System.out.print("Enter price: ");
				price=sc.nextDouble();
				sc.nextLine();
				
				System.out.print("Enter Quantity: ");
				quantity=sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter Category.Fast Food, dessert, main cource etc : ");
				category=sc.nextLine();
				
				System.out.print("Description the Food Details: ");
				description=sc.nextLine();
				
				System.out.print("Enter the Rating: ");
				rating=sc.nextInt();
				f=new Food(fname, type, price, quantity, category, description, rating);
				
				flag=fimpl.addFood(f);
				if (flag) {
				 System.out.println("New Item added to menu");	
				}
				else
					System.out.println("error while adding item");
				break;
			case 2:
				flist=fimpl.fetchAllFood();
				if (flist!=null && flist.isEmpty()!=true) {
					flist.forEach(x->{
						if(x!=null) {
						System.out.println(x);
						System.out.println("..........................");

						
						}
					});
				}
				break;
			case 3:
				System.out.println("Enter id of food name");
				foodId=sc.nextInt();
				sc.nextLine();
				f=fimpl.searchFoodById(foodId);
				if (f!=null) {
					System.out.println("your search Result---------------");
					System.out.println(f);
					
				   
					boolean b=false;
				
				do {
					System.out.println("Are you sure you want to update this detyails?");

					 System.out.println("Enter yes or no");
					    String choice=sc.next();
					    sc.nextLine();
					    
					    if (choice.equals("yes")) {
							System.out.println("Enter the option given in menu");
							System.out.println("1-->Update foodName");
							System.out.println("2-->Update type");
							System.out.println("3-->Update price");
							System.out.println("4-->Update quantity");
							System.out.println("5-->update Category ");
							System.out.println("6-->Update deccription");
							System.out.println("7-->Update rating");
							
							int option2=sc.nextInt();
							sc.nextLine();
							switch(option2) {
							case 1:
								System.out.println("Enter Food Name");
								fname=sc.nextLine();
								f.setFname(fname);
								flag=fimpl.updateFood(f);
								if (flag) {
									System.out.println("Food Name updated succesfully");
									f=fimpl.searchFoodById(foodId);
									System.out.println(f);
									System.out.println("______________");
								}
								else
									System.out.println("Error while updating this food");
								break;
								
							case 2:
								
								System.out.println("Enter Food type");
								type=sc.nextLine();
								f.setType(type);
								flag=fimpl.updateFood(f);
								if (flag) {
									System.out.println("Food type updated succesfully");
									f=fimpl.searchFoodById(foodId);
									System.out.println(f);
								}
								else
									System.out.println("Error while updating type this food");
								
								break;
								
							case 3:
								System.out.println("Enter Food price");
								price=sc.nextDouble();
								f.setPrice(price);
								flag=fimpl.updateFood(f);
								if (flag) {
									System.out.println("Food price updated succesfully");
									f=fimpl.searchFoodById(foodId);
									System.out.println(f);
								}
								else
									System.out.println("Error while updating price of this food");
								break;
								
							case 4:
								
								System.out.println("Enter Food Quantity");
								quantity=sc.nextInt();
								f.setQuantity(quantity);
								flag=fimpl.updateFood(f);
								if (flag) {
									System.out.println("Food Quantity updated succesfully");
									f=fimpl.searchFoodById(foodId);
									System.out.println(f);
								}
								else
									System.out.println("Error while updating  Quantity of  this food");
								break;
							case 5:
								System.out.println("Enter Food Category");
								category=sc.nextLine();
								f.setCategory(category);
								flag=fimpl.updateFood(f);
								if (flag) {
									System.out.println("Food Name updated succesfully");
									f=fimpl.searchFoodById(foodId);
									System.out.println(f);
								}
								else
									System.out.println("Error while updating  categoty of this food");
								break;
							case 6:
								System.out.println("Enter Food description");
								description=sc.nextLine();
								f.setDescription(description);
								flag=fimpl.updateFood(f);
								if (flag) {
									System.out.println("Food description updated succesfully");
									f=fimpl.searchFoodById(foodId);
									System.out.println(f);
								}
								else
									System.out.println("Error while updating  description of this food");
								break;
							case 7:
								System.out.println("Enter Food rating");
								rating=sc.nextInt();
								f.setRating(rating);
								flag=fimpl.updateFood(f);
								if (flag) {
									System.out.println("Food Rating updated succesfully");
									f=fimpl.searchFoodById(foodId);
									System.out.println(f);
								}
								else
									System.out.println("Error while updating rating of this food");
								break;
								default:
									System.out.println("Please Enter Corerct option");
							}
							
						}
					    else if(choice.equals("no")) {
					    	System.out.println("Thankyou for your input.please continue browsing");
					    	b=true;
					    }
					    else
					    	System.out.println("Please give input yes or no only");
				} while (b=false);
				}
				else
					System.out.println("This is  not present");
				
				break;
			
				
			case 4:
				
				
				
				System.out.println("Enter id of food name");
				foodId=sc.nextInt();
				sc.nextLine();
				f=fimpl.searchFoodById(foodId);
				if (f!=null) {
					/*
					 * System.out.println("your search Result---------------");
					 * System.out.println(f);
					 */
				   
					boolean b=false;
				
				do {
					System.out.println("Are you sure you want to delete this detyails?");

					 System.out.println("Enter yes or no");
					    String choice=sc.next();
					    sc.nextLine();
					    
					    if (choice.equals("yes")) {
							flag=fimpl.deleteFood(foodId);
							if (flag) {
								System.out.println("This item removed from your menu");
							}
							else
								System.out.println("Error while deleting the food item");
							
							
						}
					    else if(choice.equals("no")) {
					    	System.out.println("Thankyou for your input.please continue browsing");
					    	b=true;
					    }
					    else
					    	System.out.println("Please give input yes or no only");
				} while (b=false);
				}
				else
					System.out.println("This is  not present");
				
				break;
				
			case 5:
				System.out.println("Enter the Category: Main cource,dessert etc.....");
				category=sc.nextLine();
				flist=fimpl.searchFoodByCategory(category);
				
				if (flist!=null && flist.isEmpty()!=true)
				{
					flist.forEach(x->{
						if(x!=null) {
						System.out.println(x);
						System.out.println("..........................");

						
						}
					});
				
				}
				else
					System.out.println("Sorry we donot have items in this category!!");
				
				break;
			case 6:
				System.out.println("Enter name of Food Item ");
				fname=sc.nextLine();
				flist=fimpl.searchFoodByName(fname);
				

				if (flist!=null && flist.isEmpty()!=true)
				{
					flist.forEach(x->{
						if(x!=null) {
						System.out.println(x);
						System.out.println("..........................");

						
						}
					});
				
				}
				else
					System.out.println("Sorry we donot have items in this category!!");
				
				
				break;
			case 7:
				System.out.println("Enter 7---->search food item by type");
				type=sc.nextLine();
				flist=fimpl.searchFoodByType(type);
				if (flist!=null && flist.isEmpty()!=true)
				{
					flist.forEach(x->{
						if(x!=null) {
						System.out.println(x);
						System.out.println("..........................");

						
						}
					});
				
				}
				else
					System.out.println("Sorry we donot have items in this category!!");
				
				break;
			case 8:
				
				default:
					System.out.println("Enter corerct option");
					
			}
		}
	}

}
