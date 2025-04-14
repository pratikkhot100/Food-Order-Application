<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.food.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <table class="table table-success" style="text-align: center;">
    
    
    <tr>
     <th>Order Number : </th><td>${o.orderId }</td>
    </tr>
    
     
    <tr>
     <th>Billing amount : </th><td>${o.billingAmount }</td>
    </tr>
    
     
    <tr>
     <th>Order Date : </th>
     <td>
     <fmt:parseDate value="${o.orderDate }" var="d1" pattern="yyyy-MM-dd" type="date"/>
     
     <fmt:formatDate value="${d1}" dateStyle="long"/>
     
     </td>
    </tr>
         
    <tr>
     <th>Drop Loaction</th>
     <td>${o.dropLocation}
     </td>
     </tr>
     
      <tr>
     <th>Will be delivered on :</th>
     <td>
    <%
    Order o=(Order)session.getAttribute("o");
    %>
     <%= o.getDeliveryDate().format(DateTimeFormatter.ofPattern("dd-LLL-yyyy HH:mm")) %>
    
     </td>
    </tr>
    
     
    <tr>
     <th>Status : </th><td>${o.status}</td>
    </tr>
    
      </table>
       <jsp:include page="Footer.jsp"></jsp:include>
       
</body>
</html>