package com.food.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.food.dao.CardDaoImpl;
import com.food.dao.LoginDaoImpl;
import com.food.dao.OrderDaoImpl;
import com.food.pojo.Cart;
import com.food.pojo.Order;
import com.food.utility.LogInInvalidException;

public class OrderTest {
	public static void main(String[] args) {
		
		Boolean flag;
		String login=null;
		LoginDaoImpl limpl=new LoginDaoImpl();
		Scanner sc=new Scanner(System.in);
		OrderDaoImpl oimpl=new OrderDaoImpl();
		List<Order> olist;
		Order o;
		
		 Integer orderId;
		 Double billingAmount=0.0;
		 LocalDate orderDate;
		 String email;
		 String dropLocation;
		 LocalDateTime deliveryDate;
		 String status;
		
		 int year,month,dayOfMonth,hours,mins;
		 
		
		
		while(true) {
			
			Boolean exit=false;
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
			else
			{
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
			if ( login!=null && login.equals("admin")) {
				
				while (exit==false) {
					System.out.println("Enter 1---->Show all Orders");
					System.out.println("Enter 2---->Change Orders Status");
					System.out.println("Enter 3---->Logout");
					
					int option=sc.nextInt();
					sc.nextLine();
					switch(option) {
					case 1:
						olist=oimpl.showAllOrders();
						if (olist!=null && !olist.isEmpty()) {
							olist.forEach(o1->{
								System.out.println(o1);
							});
						}
						
						
						break;
					case 2:
						System.out.println("Enter order id");
						orderId=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter the new status");
						status=sc.nextLine();
						
						flag=oimpl.changeStatus(orderId, status);
						
						if (flag) {
							System.out.println("Status of this order changed!!!");
						}
						else
							System.out.println("Error while changing status");
						break;
					case 3:
						System.out.println("___________Thank you____________");
						exit=true;
						login=null;
						break;
						default :
							System.out.println("Please Enter valid input");
					}


				}
			}
			else if(login!=null && login.equals("customer")) {
				while (exit==false) {
					System.out.println("Enter 1--->Place order");
					System.out.println("Enter 2--->Cancel order");
					System.out.println("Enter 3--->My order history");
					System.out.println("Enter 4--->Check status");
					System.out.println("Enter 5-->Exit");
					
				int option=sc.nextInt();
				sc.nextLine();
				
				switch(option) {
				
				case 1:
					email=username;
					List<Cart> clist=new CardDaoImpl().showMyCart(email);
					if (clist!=null && !clist.isEmpty()) {
						System.out.println("________Your cart________");
	            		Iterator<Cart> it=clist.iterator();
	    				while (it.hasNext()) {
	    					Cart c=it.next();
	    					System.out.println("Cart id : = "+c.getCartId());
	    					System.out.println("Item : ="+c.getF().getFname());
	    					System.out.println("Quantuty : ="+c.getQuantity());
	    					System.out.println("price per item : ="+c.getPrice());
	    					System.out.println("subtotal : ="+c.getSubtotal());
	    					billingAmount+=c.getSubtotal();
	    					System.out.println("_______________________________");
	    					
	    					
	    				}
	    				System.out.println("Total bill payable : = Rs. "+billingAmount);
					}
	            		
	            		
					
					System.out.println("Do you want to place order answer : yes or no");
					String choice=sc.nextLine();
					if (choice.equals("yes")) {
						orderDate=LocalDate.now();
						System.out.println("Enter Drop Location");
						dropLocation=sc.nextLine();
						
						System.out.println("enter delivery date details as follow");
						System.out.println("Enter dayOf Month  number between 1-31: ");
						dayOfMonth=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter month of year : Number between 1-12");
						month=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter year");
						year=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter time of delivery details :");
						System.out.println("Enter hour: Number between 0 to 23");
						hours=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter Minutes: Number between 0 to 59");
						mins=sc.nextInt();
						sc.nextLine();
						
						deliveryDate=LocalDateTime.of(year, month, dayOfMonth, hours, mins);
						status="Confirmed";
						
				      o=new Order(billingAmount, orderDate, email, dropLocation, deliveryDate, status);
				      
				      Order o1=oimpl.placeOrder(o);
				      
				      if (o1!=null) {
						System.out.println("_________your Order has been placed succesfully________");
						
						System.out.println("___________Details___________");
						System.out.print("Order no : "+o1.getOrderId());
						deliveryDate=o1.getDeliveryDate();
						System.out.print(" It will be delivered on : "+o1.getDeliveryDate().getDayOfMonth());
						System.out.println(" "+deliveryDate.getMonth()+"/"+deliveryDate.getYear());
						System.out.println();
						
						System.out.println("Timing: "+deliveryDate.getHour()+" : "+deliveryDate.getMinute());
						
						System.out.println("Drop location : "+o1.getDropLocation());
						System.out.println("Status : "+o1.getStatus());
					}
				      else
				    	  System.out.println("Erroe while plqacing order");
						
					}
					
					
					
					break;
				case 2://cancel order
					System.out.println("Enter the id of order you want to cancel");
					orderId=sc.nextInt();
					sc.nextLine();
					
					flag=oimpl.cancelOrder(orderId);
					if (flag) {
						System.out.println("Your order has been canceled");
					}
					else
						System.out.println("Error while cancelling order");
					
					break;
					
				case 3:
					email=username;
					olist=oimpl.showOrderHistory(email);
					
					if (olist!=null && !olist.isEmpty()) {
						for (Order o1 : olist) {
							
							
							System.out.print("Order no : "+o1.getOrderId());
							deliveryDate=o1.getDeliveryDate();
							
							System.out.print(" It will be delivered on : "+o1.getDeliveryDate().getDayOfMonth());
							System.out.println(" "+deliveryDate.getMonth()+"/"+deliveryDate.getYear());
							System.out.println();
							
							System.out.println("Timing: "+deliveryDate.getHour()+" : "+deliveryDate.getMinute());
							
							System.out.println("Drop location : "+o1.getDropLocation());
							System.out.println("Status : "+o1.getStatus());
						}
						
					}
					
					break;
				case 4://check status
					System.out.println("Enter orderId");
					orderId=sc.nextInt();
					sc.nextLine();
					status=oimpl.checkStatus(orderId);
					System.out.println("The status of this orderId is : "+status);
					break;
					
				case 5:
					System.out.println("__________Thank you_____________");
					exit=true;
					login=null;
					break;
					default:
						System.out.println("Please Enter valid input");
				
				
				
			         	}
					
				}
			}
			
			else
			{
				System.out.println("No food item to cart till now");
				break;
			}
			
		}

		
		
	
	}
}
