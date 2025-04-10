package com.food.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PrimitiveIterator.OfDouble;
import java.util.Scanner;

import com.food.dao.CardDaoImpl;
import com.food.dao.LoginDaoImpl;
import com.food.pojo.Cart;
import com.food.pojo.Food;
import com.food.pojo.FoodDaoImpl;
import com.food.utility.LogInInvalidException;

public class CartTest {
	public static void main(String[] args) {
		
	Scanner sc=new Scanner(System.in);
		LoginDaoImpl limpl=new LoginDaoImpl();
		CardDaoImpl cimpl=new CardDaoImpl();
		Cart c=null;
		List<Cart> clist=null;
		int option;
		Food f=null;
		FoodDaoImpl fimpl=new FoodDaoImpl();
		List<Food> flist=null;
		Boolean flag;
	     String login=null;
	     
	      Integer cartId;
	      Integer foodId;
	     
	      Integer quantity;
	      Double subtotal=null;
	      String email;
	      Double price=null;
	     
	     while(true) {
	    	 
		System.out.println("Welcome to Cart Menu");
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
			
		if (login.equals("admin")) {
			
			clist=cimpl.showAllCard();
			if (clist!=null && !clist.isEmpty()) {
				Iterator<Cart> it=clist.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
					
					
				}
				break;
				
			}
			else
			{
				System.out.println("No food item to cart till now");
				break;
			}
			
			
		}
		else if(login.equals("customer")) {
			boolean exit=false;
			do {
			System.out.println("__________Cart Menu__________");
			System.out.println("Enter 1-->Add to Cart");
			System.out.println("Enter 2-->Show my  Cart");
			
			System.out.println("Enter 3-->Clear my cart");
			System.out.println("Enter 4-->Log out");


           
            option=sc.nextInt();
            sc.nextLine();
            
            
            switch(option) {
            case 1:
            	flist=fimpl.fetchAllFood();
            	if (flist!=null && !flist.isEmpty()) {
					for(Food f1:flist) {
						System.out.println("Food id ="+f1.getFoodId());
						System.out.println("Name = "+f1.getFname());
						System.out.println("Price = "+f1.getPrice());
						System.out.println("Type = "+f1.getType());
						System.out.println("_______________________");


					}
					System.out.println("Enter the foodId of food to be added to cart..");
				    foodId=sc.nextInt();
				    sc.nextLine();
				    
				    System.out.println("How many  of this item would you like to add ");
				    quantity=sc.nextInt();
				    sc.nextLine();
				    
				    Map<Double, Double> m=cimpl.fetchPriceSubtotal(foodId, quantity);
				    
				    if(m!=null)
				    {
				    for(Entry<Double, Double> me:m.entrySet()) {
				    	if(m!=null) {
				    	 price=me.getKey();
				    	 subtotal=me.getValue();
				    	
				    	}
				    	}
				    }
				    else 
				    {
				    	System.out.println("Error while fetching price and qyantity");
				     break;
				    }
					c=new Cart();
					c.setFoodId(foodId);
					c.setEmail(username);
					c.setPrice(price);
					c.setSubtotal(subtotal);
					c.setQuantity(quantity);
					flag=cimpl.addToCart(c);
					if (flag) {
						System.out.println("Your item has been added to cart succesfully");
						
					}
					else
						System.out.println("Error while adding this item to cart!! Try again..");
					
					
            	}
            	else
            		System.out.println("No data available");
            	
            	break;
            case 2:
            	email=username;//the username given during is the email
            	clist=cimpl.showMyCart(email);
            	double total=0;
            	boolean exit2=false;
            	
            	if (clist!=null && !clist.isEmpty()) {
					System.out.println("________Your cart________");
            		Iterator<Cart> it=clist.iterator();
    				while (it.hasNext()) {
    					c=it.next();
    					System.out.println("Cart id : = "+c.getCartId());
    					System.out.println("Item : ="+c.getF().getFname());
    					System.out.println("Quantuty : ="+c.getQuantity());
    					System.out.println("price per item : ="+c.getPrice());
    					System.out.println("subtotal : ="+c.getSubtotal());
    					total+=c.getSubtotal();
    					System.out.println("_______________________________");
    					
    					
    				}
    				
            		System.out.println("Total bill payable : = Rs. "+total);
            		while (exit2==false) {
						System.out.println("Enter 1--->update quantity of an item");
						System.out.println("Enter 2--->Delte an Item from Card");
						System.out.println("Enter 3--->Go back to menu");
						
						
						int choice=sc.nextInt();
						sc.nextLine();
						
						if (choice==1) {
							System.out.println("Enter the CartId whose quantity need to be updated");
							cartId=sc.nextInt();
							sc.nextLine();
							
							System.out.println("Enter new Quantity");
							quantity=sc.nextInt();
							sc.nextLine();
							
							flag=cimpl.updateQuantity(cartId, quantity);
							
							if (flag) {
								System.out.println("Quantity of the item has been changed...");
								System.out.println("do you want to continue answer in yes or no");
								
								if(sc.nextLine().equalsIgnoreCase("yes")) {
									System.out.println("Thank yoy for input");
								}
								else
								{
									exit2=true;
								}
							}
						}
						
						
						else if(choice==2) {
							
							System.out.println("Enter the CartId which you want to deleted");
							cartId=sc.nextInt();
							sc.nextLine();
							flag=cimpl.deleteCartItem(cartId);
							if(flag) {
							System.out.println("This item has been deleted: ");
							System.out.println("do you want to continue answer in yes or no");
							
							if(sc.nextLine().equalsIgnoreCase("yes")) {
								System.out.println("Thank yoy for input");
							}
							
							}	
							
						}
						else
							exit2=true;
							
						
						
					}
            		
                	
				}
            	
            	else
            		System.out.println("No food item added to your card till now...");
            	break;
            case 3:
            	
            	email=username;
            	flag=cimpl.clearMyCard(email);
            	if (flag) {
					System.out.println("you cart is empty now..");
				}
            	else
            		System.out.println("Error while removing items from your cart...");
            	
            	break;
            case 4:
            	System.out.println("You have Clicked logout. Do you want to continue");
            	System.out.println("Answer yes or no");
            	String choice=sc.nextLine();
            	
            	if (choice.equalsIgnoreCase("yes")) {
            		System.out.println("Thank you visit us soon");
            		exit=true;
					
				}
            	else if (choice.equalsIgnoreCase("no")) {
					System.out.println("Thank you continue browsing");
				}
            	else
            		System.out.println("Invalid Input");
            	break;
            default:
            	System.out.println("please Enter given option only....");
            }
			}while(exit==false);			
			
		}
		else
		{
			System.out.println(".....please login to continue...........");
		}
		
	     }
		
	}

}
