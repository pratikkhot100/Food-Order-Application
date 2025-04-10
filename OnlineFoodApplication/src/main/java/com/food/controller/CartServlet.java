package com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.dao.CardDaoImpl;

import com.food.pojo.Cart;
import com.food.pojo.Food;
import com.food.pojo.FoodDaoImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Integer cartId;
	private Integer foodId;
	private Food f;
	private Integer quantity;
	private Double subtotal;
	private String email;
	private Double price;
	
	HttpSession session=null;
	RequestDispatcher rd=null;
	
	Cart c=null;
	List<Cart> cartList=null;
	CardDaoImpl cimpl=new CardDaoImpl();
	
	Boolean flag;
	
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		session=request.getSession();
		
		if(process!=null && process.equals("addToCart")) {
			
			foodId=Integer.parseInt(request.getParameter("food_id"));
			quantity=1;
			FoodDaoImpl fimpl=new FoodDaoImpl();
			
			f=fimpl.searchFoodById(foodId);
			
			price=f.getPrice();
			
			subtotal=quantity*price;
			
			email=(String)session.getAttribute("email");
			
			c=new Cart();
			c.setEmail(email);
			c.setFoodId(foodId);
			c.setPrice(price);
			c.setQuantity(quantity);
			c.setSubtotal(subtotal);
			
			boolean present=cimpl.checkCartItem(foodId, email);
			
			if(present) {
				
				request.setAttribute("msg", "This item was already present; "
						+ "so one more plate added");
				
			}
			else {
				
			flag=cimpl.addToCart(c);
			if(flag) 
				request.setAttribute("msg", "Your item has been added to cart!!");
				
			else 
				request.setAttribute("errorMsg", "Error while adding this item to cart");
				
			}//end of outer else of present
			
			List<Food> flist=new FoodDaoImpl().fetchAllFood();
			session.setAttribute("flist", flist);
			
			rd=request.getRequestDispatcher("FoodList.jsp");
			rd.forward(request, response);
			
		}
		else if(process!=null && process.equals("myCart")) {
			
			email=(String)session.getAttribute("email");
			cartList=cimpl.showMyCart(email);
			
			if(cartList!=null && !cartList.isEmpty()) {
				
				session.setAttribute("cartList", cartList);
				response.sendRedirect("MyCart.jsp");
			}
			
			else {
				
				request.setAttribute("errorMsg", "Your cart is empty. Please add food items to the cart first!!");
				List<Food> flist=new FoodDaoImpl().fetchAllFood();
				session.setAttribute("flist", flist);
				
				rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
				
			}
		}
		else if(process!=null && process.equals("deleteCartItem")) {
			cartId=Integer.parseInt(request.getParameter("cartId"));
			flag=cimpl.deleteCartItem(cartId);
			
			if (flag) {
				request.setAttribute("msg", "Item deleted succesfully");
				session.setAttribute("cartList", cartList);
				response.sendRedirect("MyCart.jsp");
			}
			else {
				request.setAttribute("msg", "you card is empty please add item");
				List<Food> flist=new FoodDaoImpl().fetchAllFood();
				session.setAttribute("flist", flist);
				
				rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
			}
		}
		else {
			request.setAttribute("errorMsg", "Error while daleting this item");
			rd=request.getRequestDispatcher("FoodList.jsp");
			rd.forward(request, response);
		}
	     
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String process=request.getParameter("process");
		Gson g=new Gson();
		
		if(process!=null && process.equals("updateQuantity")) {
			
			System.out.println("Inside updateQuantity");
			cartId=Integer.parseInt(request.getParameter("cartId"));
			quantity=Integer.parseInt(request.getParameter("quantity"));
			
			flag=cimpl.updateQuantity(cartId, quantity);
			if(flag) {
				email=(String)session.getAttribute("email");
				cartList=cimpl.showMyCart(email);
				
				  System.out.println("cart list in update quantity:\n"+cartList);
				  
				  List<Food> foodList=new ArrayList<>();
				  
				  for(Cart c1:cartList) {
				  
				  foodList.add(c1.getF());
				  
				  } 
				  PrintWriter pw=response.getWriter();
				  
				  pw.print(g.toJson(cartList)+"&&"); 
				  pw.print(g.toJson(foodList));
				 
				
				
				
			}
			else {
				request.setAttribute("errorMsg", "Error while updating quantity");
				
				rd=request.getRequestDispatcher("MyCart.jsp");
				rd.forward(request, response);
				
			}
		}
	}

}