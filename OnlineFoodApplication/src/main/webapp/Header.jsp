<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <meta name="keywords" content="" />
<meta name="description" content="" />
	<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--  Free CSS Template by TemplateMo.com  --> 
<div id="templatemo_container">
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <%
     String login=(String)session.getAttribute("login");
    
    %>
    
    <div id="templatemo_menu">
        <ul>
        	<li class="current"><a href="Home.jsp"><b>Home</b></a></li>
        	
        	<% if(login!=null && login.equals("admin")){ %>
            <li><a href="AddFood.jsp"><b>Add food</b></a></li>
             <li><a href="OrderServlet?process=allOrders"><b>All Order</b></a></li>
            
            
            <% }%>
            <li><a href="FoodServlet?process=allFood"><b> Menus</b></a></li>
            <li><a href="Company.jsp"><b>Company</b></a></li>
            <li ><a href="Contact.jsp"><b>Contact</b></a></li>
            <%if(login!=null && login.equals("customer")){ %>
             <li><a href="CustomerServlet?process=myProfile"><b>Profile</b></a></li>
              <li><a href="CustomerServlet?process=deleteProfile"><b>Delete Profile</b></a></li>
              <li><a href="CartServlet?process=myCart"><img src="images/cart.png" style="color:white; width: 35px;"></a></li>
              <li><a href="OrderServlet?process=orderHistory"><b>My Order History</b></a></li>
              
             
             
             
            
            <%}%>
            
            <%if(login==null){ %>
            
             <li ><a href="Login.jsp"><b>Login</b></a></li>
               <li><a href="AddCustomer.jsp"><b>Register</b></a></li>
             
             <%} %>
             <% if(login!=null){ %>
          <li ><a href="LoginServlet?process=logout" onclick="return confirm('Are you sure you want logout?')"><b>Log out</b></a></li>
          <%}%>
            
        </ul>
    </div>
</body>
</html>