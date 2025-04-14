package com.food.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.food.dao.CardDaoImpl;
import com.food.dao.OrderDaoImpl;
import com.food.pojo.Cart;
import com.food.pojo.Food;
import com.food.pojo.FoodDaoImpl;
import com.food.pojo.Order;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	 Integer orderId;
	 Double billingAmount;
	 LocalDate orderDate;
	 String email;
	 String dropLocation;
	 LocalDateTime deliveryDate;
	 String status;
	
	HttpSession session;
	RequestDispatcher rd;
	
	Order o;
	OrderDaoImpl oimp=new OrderDaoImpl();
	List<Order> olist;
	Boolean flag;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		session=request.getSession();
		if (process!=null && process.equals("orderHistory")) {
		     email=(String)session.getAttribute("email");
		     olist=oimp.showOrderHistory(email);
		     System.out.println("olist in my history\n"+olist);
		     
		     if (olist==null || olist.isEmpty()) {
				request.setAttribute("errorMsg", "You have not order anything till now");
			    List<Food> flist=new FoodDaoImpl().fetchAllFood();
			    session.setAttribute("flist", flist);
			    rd=request.getRequestDispatcher("FoodList.jsp");
			    rd.forward(request, response);
		     }
		     else {
				session.setAttribute("olist", olist);
				response.sendRedirect("OrderList.jsp");
			}
		    
		     }

		else if (process!=null && process.equals("cancelOrder")) {
	    	 orderId=Integer.parseInt(request.getParameter("orderId"));
			 flag= oimp.cancelOrder(orderId);
			
			if (flag) {
				request.setAttribute("msg", "food cancel succesfully");
				  List<Food> flist=new FoodDaoImpl().fetchAllFood();
					if (olist!=null && !olist.isEmpty()) {
						session.setAttribute("olist", olist);
						rd=request.getRequestDispatcher("FoodList.jsp");
						rd.forward(request, response);
					}
					else {
						request.setAttribute("errorMsg", "please  try again");
						rd=request.getRequestDispatcher("Home.jsp");
						rd.forward(request, response);
						
					}
			}
			
	     }
		else if(process!=null && process.equals("allOrders")) {
			olist=oimp.showAllOrders();
			if (olist!=null && !olist.isEmpty()) {
				session.setAttribute("olist", olist);
				response.sendRedirect("OrderList.jsp");
			}
			else {
				request.setAttribute("errorMsg", "No one has ordered anything yet :::");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
		}
		else if(process!=null && process.equals("completeOrder")) {
		orderId=Integer.parseInt(request.getParameter("orderId"));
		flag=oimp.changeStatus(orderId, "Completed");
		if (flag) {
			request.setAttribute("msg", "Order completed succesfully");
			
		     olist=oimp.showAllOrders();
		    rd=request.getRequestDispatcher("OrderList.jsp");
		   rd.forward(request, response);
		}
		else {
			request.setAttribute("errorMsg", "Error while cancelling order!!");
			rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		session=request.getSession();
		if (process!=null && process.equals("placeOrder")) {
			billingAmount=Double.parseDouble(request.getParameter("billingAmount"));
			orderDate=LocalDate.now();
			email=(String)session.getAttribute("email");
			o=new Order();
			
			o.setBillingAmount(billingAmount);
			o.setEmail(email);
			o.setOrderDate(orderDate);
			
			request.setAttribute("msg", "please conform your order");
			request.setAttribute("orderObj", o);
			rd=request.getRequestDispatcher("ConfirmOrder.jsp");
			rd.forward(request, response);
			
			
		}
		else if(process!=null && process.equals("confirmOrder")) {
			billingAmount=Double.parseDouble(request.getParameter("billingAmount"));
			orderDate=LocalDate.parse(request.getParameter("orderDate"));
			email=request.getParameter("email");
			dropLocation=request.getParameter("dropLocation");
			LocalDate date=LocalDate.parse(request.getParameter("deliveryDate"));
			
			LocalTime time=LocalTime.parse(request.getParameter("deliveryTime"));
			deliveryDate=LocalDateTime.of(date, time);
			o=new Order(billingAmount, orderDate, email, dropLocation, deliveryDate, "Confirm");
		    Order o1=oimp.placeOrder(o);
		    
		    if (o1!=null) {
				request.setAttribute("msg", "Your order has been palced successfully");
			    CardDaoImpl cimpl=new CardDaoImpl();
			    List<Cart> clist=cimpl.showMyCart(email);
			    for (Cart cart : clist) {
					new FoodDaoImpl().updateFoodQuantity(cart.getFoodId(),cart.getQuantity());
					
				}
				cimpl.clearMyCard(email);
				session.setAttribute("o", o1);
				rd=request.getRequestDispatcher("Invoice.jsp");
				rd.forward(request, response);
				
		    }
		    else {
				request.setAttribute("errorMsg", "Error while palcing order");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
		}
		
	}

}
