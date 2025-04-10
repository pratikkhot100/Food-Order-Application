<%@page import="com.food.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Order</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Message.jsp"></jsp:include>
<%
    Order o=(Order)request.getAttribute("orderObj");
   pageContext.setAttribute("o", o,pageContext.PAGE_SCOPE);
    
%>
    <form action="OrderServlet" method="post">
    <input type="hidden" name="process" value="confirmOrder">
    <table>
     
    <tr>
    <th>Billing Ammount</th><td><input name="billingAmount" type="text" value="${o.billingAmount }"  readonly="readonly"></td>
    </tr>
    
     <tr>
    <th>Order Date </th><td><input type="text" name="orderDate" value="${o.orderDate }" readonly="readonly"></td>
    </tr>
    
      <tr>
    <th>Email </th><td><input type="text" name="email" value="${o.email }"  readonly="readonly"></td>
    </tr>
      <tr>
    <th>Drop Location </th><td><input type="text" name="dropLocation" value="${o.dropLocation }"></td>
    </tr>
    
    <tr>
    <th>Date of Delivery </th><td><input name="deliveryDate" type="date"></td>
    </tr>
    
     <tr>
    <th>Time of Delivery </th><td><input type="time" name="deliveryTime"></td>
    </tr>
   
   
<tr>
<td><input type="reset"class="btn btn-danger"  value="Reset"></td><td><input class="btn btn-success" type="submit" value="Confirm"></td>
</tr>
    </table>
    </form>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>