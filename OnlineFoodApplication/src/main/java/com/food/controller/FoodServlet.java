package com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.pojo.Food;
import com.food.pojo.FoodDaoImpl;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Integer food_id;
	private String fname;
	private String type;//veg or non veg
    private Double price;
    private Integer quantity;
    private String category;
    private String description;
    private Integer rating;
    Boolean flag;
    
    Food f=null;
    List<Food> flist=null;
    FoodDaoImpl fimpl=new FoodDaoImpl();
    RequestDispatcher rd=null;
    HttpSession session=null;
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String process=request.getParameter("process");
		session=request.getSession();
		if (process!=null && process.equals("allFood")) {
			flist=fimpl.fetchAllFood();
			if (flist!=null && !flist.isEmpty()) {
				session.setAttribute("flist", flist);
				response.sendRedirect("FoodList.jsp");
			}else {
				request.setAttribute("errorMsg", "Menu is empty . please try again later");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);
			}
		}
		else if(process!=null && process.equals("updateFood")) {
			food_id=Integer.parseInt(request.getParameter("foodId"));
			f=fimpl.searchFoodById(food_id);
			session.setAttribute("foodObj", f);
			response.sendRedirect("UpdateFood.jsp");
		}
		else if (process!=null && process.equals("DeleteFood")) {
		   food_id=Integer.parseInt(request.getParameter("foodId"));
		   f=fimpl.searchFoodById(food_id);
		  flag= fimpl.deleteFood(food_id);
		  if (flag) {
				request.setAttribute("msg", "Food deleted successfully!!!");
				
				flist=fimpl.fetchAllFood();

				if (flist!=null && !flist.isEmpty()) {
					session.setAttribute("flist", flist);
					rd=request.getRequestDispatcher("FoodList.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("errorMsg", "Menu is empty try again");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
					
				}
		}
		  else {
			  request.setAttribute("errorMsg", "Error while deliting food");
				rd=request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);	
		}
		  
	}
    	
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 session=request.getSession();
		String process=request.getParameter("process");
		if (process!=null && process.equals("addFood")) {
			
			 fname=request.getParameter("fname");
			
			 type=request.getParameter("type");
			
			 price=Double.parseDouble(request.getParameter("price"));
			
			 quantity=Integer.parseInt(request.getParameter("quantity"));

			 category=request.getParameter("category");

			 description=request.getParameter("description");

			 rating=Integer.parseInt(request.getParameter("rating"));
			
			f=new Food(fname, type, price, quantity, category, description, rating);
			
			flag=fimpl.addFood(f);
			if (flag) {
				request.setAttribute("msg", "Food details added successfully!!!");
				
				rd=request.getRequestDispatcher("AddFood.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("errorMsg", "Error while adding food!!!");
				rd=request.getRequestDispatcher("AddFood.jsp");
				rd.forward(request, response);
				
			}

			
			
		}
		else if (process!=null && process.equals("UpdateFoodItem")) {

			 fname=request.getParameter("fname");
			 type=request.getParameter("type");
			 price=Double.parseDouble(request.getParameter("price"));
			 quantity=Integer.parseInt(request.getParameter("quantity"));
			 category=request.getParameter("category");
			 description=request.getParameter("description");
			 rating=Integer.parseInt(request.getParameter("rating"));
			 food_id=Integer.parseInt(request.getParameter("foodId"));
			 f=new Food(food_id, fname, type, price, quantity, category, description, rating);
            
			 flag=fimpl.updateFood(f);
			 if (flag) {
				request.setAttribute("msg", "Food updated succesfully");
				flist=fimpl.fetchAllFood();
				
				if (flist!=null && !flist.isEmpty()) {
					session.setAttribute("flist", flist);
					rd=request.getRequestDispatcher("FoodList.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("errorMsg", "Menu is empty try again");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
					
				}
			}
			 else {
					request.setAttribute("errorMsg", "Error while updating food");
					rd=request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
			}
			
		}
		if (process!=null && process.equals("searchFood")) {
			String userInput=request.getParameter("userInput");
			String search=request.getParameter("search");

			
			
			if (search!=null && search.equals("byCategory")) {
				
				flist=fimpl.searchFoodByCategory(userInput);
				session.setAttribute("flist", flist);
				rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
				
			}
			else if (search!=null && search.equals("byType")){
				
				flist=fimpl.searchFoodByType(userInput);
				session.setAttribute("flist", flist);
				rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);

			}
			else if(search!=null && search.equals("byName")) {

				flist=fimpl.searchFoodByName(userInput);
				session.setAttribute("flist", flist);
				rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request, response);
				
			}
			
		
			else {
				
				request.setAttribute("errorMsg", "error");
				response.sendRedirect("Home.jsp");
			}
			
			
		}
		
	}

}
