package com.food.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.CustomerDaoImpl;
import com.food.pojo.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private Integer cusId; 
	private String cname;
	private String address;
	private String email;
	private Long contactNo;
	private String password;
	
	 RequestDispatcher rd=null;
	    HttpSession session=null;
	CustomerDaoImpl cimpl=new CustomerDaoImpl();;
	Customer c=null;
	boolean flag;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("myProfile")) {
	        	
	        	email=(String)session.getAttribute("email");
	        	c=cimpl.searchCustomerByEmail(email);
	        	session.setAttribute("custObj", c);
	        	response.sendRedirect("UpdateCustomer.jsp");
	        }
		else if(process!=null && process.equals("deleteProfile")) {
			email=(String)session.getAttribute("email");
			c=cimpl.searchCustomerByEmail(email);
			flag=cimpl.deleteCustomer(c.getCusId());
			
			
			if (flag) {
				
					 request.setAttribute("msg", "your profile deleted!!!");
						session.invalidate();
						rd=request.getRequestDispatcher("Home.jsp");
						rd.forward(request, response);	
			}
			else {
				 request.setAttribute("errorMsg", "while deleting your profile !!!");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);	
			}
			
   		}
		
		  
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		session=request.getSession();
        if(process!=null && process.equals("addcustomer")) {
        	
		cname=request.getParameter("cname");
		 address=request.getParameter("address");
		 email=request.getParameter("email");
		 contactNo=Long.parseLong(request.getParameter("contactNo"));
		 password=request.getParameter("password");
		 
		 c=new Customer(cname, address, email, contactNo, password);
		 flag=cimpl.addCustomer(c);
		 if (flag) {
			 request.setAttribute("msg", "Customer details added successfully!!!");
				
				rd=request.getRequestDispatcher("AddCustomer.jsp");
				rd.forward(request, response);
			 
		}
      
		 else {
			 request.setAttribute("errorMsg", "Error while adding  customer!!!");
				rd=request.getRequestDispatcher("AddCustomer.jsp");
				rd.forward(request, response);
		}
		
		 
        
        }
        if (process!=null && process.equals("UpdateCustomerDetails")) {
        	cusId=Integer.parseInt(request.getParameter("cusId"));
			cname=request.getParameter("cname");
			address=request.getParameter("address");
			email=request.getParameter("email");
			contactNo=Long.parseLong(request.getParameter("contactNo"));
			password=request.getParameter("password");
			c=new Customer(cusId, cname, address, email, contactNo, password);
			flag=cimpl.updateCustomer(c);
			if (flag) {
                request.setAttribute("msg", "Customer details updataed successfully!!!");
				
				rd=request.getRequestDispatcher("UpdateCustomer.jsp");
				rd.forward(request, response);
			}
			 else {
				 request.setAttribute("errorMsg", "Error while updating  customer!!!");
					rd=request.getRequestDispatcher("UpdateCustomer.jsp");
					rd.forward(request, response);
			}
			
        	
		}
       
		
		
	}

}
