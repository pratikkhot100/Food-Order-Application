<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.food.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
      <jsp:include page="Header.jsp"></jsp:include>
   <jsp:include page="Message.jsp"></jsp:include> 
   <form action="">
  <table class="table table-success" style="text-align: center;">
  <tr>
  <th>Order number</th>
   <th>Billing amount : </th>
   <th>Order date : </th>
   <th>Delivery Date and time </th>
   <th>Status </th>
   <th colspan="2">Action </th>
  </tr>
 <%
 List<Order>olist=(List<Order>)session.getAttribute("olist");
 for(Order o1:olist){
 %>
  
  

  <tr>
  <td><%= o1.getOrderId() %></td>
  <td><%=o1.getBillingAmount() %></td>
  <td>
   <%= o1.getOrderDate().format(DateTimeFormatter.ofPattern("dd-LLL-yyyy")) %>
     
     </td>
     <td>
  
     <%= o1.getDeliveryDate().format(DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm")) %>
     </td>
     <%String login=(String)session.getAttribute("login"); %>
     
     <td>
     <%=o1.getStatus() %>
     <%if(!o1.getStatus().equals("Cancelled") && !o1.getStatus().equals("Completed")){ %>
     
     
     <td><a class="btn btn-success" href="OrderServlet?process=cancelOrder&orderId=<%=o1.getOrderId() %>">Cancel</a></td>
     
      <%}if(login!=null && login.equals("admin")) {%>
      <td><a class="btn btn-success" href="OrderServlet?process=completeOrder&orderId=<%= o1.getOrderId()%>">Completed</a>
      <%}else{ %>
      <td></td>
  
  <%} %>
  </tr>
  <%} %>
  </table>


</form>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>