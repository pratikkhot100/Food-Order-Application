package com.food.test;

import java.util.List;
import java.util.Scanner;

import com.food.dao.CustomerDaoImpl;
import com.food.pojo.Customer;

public class CustomerTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CustomerDaoImpl cimpl=new CustomerDaoImpl();
		Customer c=null;
		List<Customer> clist=null;
		 Integer cusId;
		 String cname;
		 String address;
		 String email;
		 Long contactNo;
		 String password;
		 Boolean flag;
		 
		 System.out.println(".....Welcome User............");
		 while (true) {
			 System.out.println("Enter the number as given in option");
				System.out.println("Enter 1-->please sighIn");
				System.out.println("Enter 2-->show all customer");
				System.out.println("Enter 3-->update customer");
				System.out.println("Enter 4-->Delete  by ID");
				System.out.println("Enter 5-->Search  by name");
				System.out.println("Enter 6-->Search  by Email");
				

				
				int option=sc.nextInt();
				sc.nextLine();
				
				switch(option) {
				case 1:
					System.out.println("Enter your name");
					cname=sc.nextLine();
					
					System.out.println("Enter your Address");
					address=sc.nextLine();
					
					
					System.out.println("Enter your email");
					email=sc.nextLine();
					flag=cimpl.uniequeEmail(email);
					while(flag) {
						System.out.println("This email already been used");
						System.out.println("plaese give another email id ");
						email=sc.nextLine();
						flag=cimpl.uniequeEmail(email);
					}
					
					
					
					System.out.println("Enter Contact Number");
					contactNo=sc.nextLong();
					sc.nextLine();
					
					System.out.println("Enter password");
					password=sc.nextLine();
					
			
					flag=cimpl.uniquePassword(password);
					while(flag) {
						System.out.println("This password already been used");
						System.out.println("plaese give another password id ");
						password=sc.nextLine();
						flag=cimpl.uniquePassword(password);
					}
					
					
					c=new Customer(cname, address, email, contactNo, password);
					flag=cimpl.addCustomer(c);
					
					if (flag) {
						System.out.println("SignUp succesfull");
					}
					else
						System.out.println("Error while signin");
					break;
					
				case 2:
					clist=cimpl.seachAllCustomer();
					if (clist!=null && !clist.isEmpty()) {
					    clist.forEach(a->{
					    	System.out.println(a);
					    	System.out.println("_________________");
					    	
					    });
						
					}
					else
						System.out.println("data base is empty");
					break;
				case 3:
					System.out.println("Enter customer id");
					cusId=sc.nextInt();
					sc.nextLine();
					c=cimpl.searchCustomerById(cusId);
					
					if (clist!=null) {
						System.out.println("your profile");
						System.out.println(c);
						
						boolean exit=false;
						while(exit==false) {
						System.out.println("Are you sure you want to update your prifile"+
								"Update this profile ?\nAnswer in yes or no");
						
						    String choice=sc.next().toLowerCase();
						if (choice.equals("yes")) {
							 System.out.println("What do you want update");
							 
							 System.out.println("1-->Enter name");
							 
							 
							 System.out.println("2-->Enter address");
							 
							 
							 System.out.println("3-->enter email");
							 
							 System.out.println("4-->Enter contactNo");
							 
							 
							 int i=sc.nextInt();
							 sc.nextLine();
							 
							 switch(i) {
							 case 1:
								 System.out.println("Enter new name");
								 cname=sc.nextLine();
								 c.setCname(cname);
								 flag=cimpl.updateCustomer(c);
								 if (flag) {
									System.out.println("name update succesfully");
									
								}
								 else
									 System.out.println("error while updating name");
								 
								 break;
							 case 2:
								 System.out.println("Enter address");
								 address=sc.nextLine();
								 c.setAddress(address);
								 flag=cimpl.updateCustomer(c);
								 if (flag) {
									System.out.println("Address updates succesfully");
								}
								 else System.out.println("error while updating address");
								 break;
							 case 3:
								System.out.println("Enter Email Addrses");
								email=sc.nextLine();
								c.setEmail(email);
								flag=cimpl.updateCustomer(c);
								if (flag) {
									System.out.println("Email updating succesfully");
								}
								else
									System.out.println("Error while updating email address");
								 break;
							 case 4:
								 System.out.println("Enter contact no");
								 contactNo=sc.nextLong();
								 sc.nextLine();
								 c.setContactNo(contactNo);
								 flag=cimpl.updateCustomer(c);
										 if (flag) {
											System.out.println("contact number updated");
											
										}
										 else
											 System.out.println("Error while update contact no");
										 break;
								
							 }
							 
						}
						else if(choice.equals("no")) {
							System.out.println("No issue .Please continue browsing..");
							exit=true;
						}
						}
					}
					break;
				case 4:
					System.out.println("Enter ID which you want to Delete");
					cusId=sc.nextInt();
					sc.nextLine();
					c=cimpl.searchCustomerById(cusId);
					if (c!=null) {
						System.out.println("Your profile");
						System.out.println(c);
						
						
						boolean exit=false;
						do {
							System.out.println("Are sure you want to delete");
							String choice=sc.next();
							sc.nextLine();
							if (choice.equals("yes")) {
								flag=cimpl.deleteCustomer(cusId);
								if (flag) {
									System.out.println("customer deleted succcesfully");
									
								}
								else
									System.out.println("Error while deleting the customer");
								
							}
							else if(choice.equals("no")) {
								System.out.println("continue browsing");
								exit=false;
							}
							else 
								System.out.println("lease answer yes or no");	
							
						}while(flag=false);
					}
					
					break;
				case 5:
					System.out.println("Enter name which you want to search");
					cname=sc.nextLine();
					clist=cimpl.searchCustomerByName(cname);
					if (clist!=null) {
						clist.forEach(w->{
						System.out.println(w);
						});
					}
					else {
						System.out.println("not present name ");
					}
					break;
				case 6:
					
					System.out.println("Enter Email which you want to search");
					email=sc.nextLine();
					c=cimpl.searchCustomerByEmail(email);
					if (c!=null) {
						System.out.println(c);
					}
					else {
						System.out.println("email is not prsent ");
					}
					
					break;
					default:
						System.out.println("please enter correct option");
				}
		}
		 
	}

}
