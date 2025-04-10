<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
	<%
	String login = (String) session.getAttribute("login");
	if (login == null) {
		request.setAttribute("errorMsg", "please login for better experience");
	}
	%>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="Message.jsp"></jsp:include>
	<table class="table table-success" style="text-align: center;">

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>Price</th>
			<th>Stock</th>
			<th>Category</th>
			<th>Description</th>
			<th>Rating</th>
			<%
			if (login != null) {
			%>
			<th colspan="2">Action</th>

			<%
			}
			%>
		</tr>
		<c:forEach var="food" items="${flist}">
			<tr>
				<td>${food.foodId }</td>
				<td>${food.fname }</td>
				<td>${food.type }</td>
				<td>${food.price }</td>
				<c:if test="${food.quantity==0 }">
				<td>out of stock</td>
				</c:if>
				<c:if test="${food.quantity!=0 }">
				<td>${food.quantity }</td>

				</c:if>
				<td>${food.category }</td>
				<td>${food.description }</td>
				<td>${food.rating }</td>
				<%
				if (login != null) {
				%>

				<%
				if (login.equals("admin")) {
				%>
				<td><a
					href="FoodServlet?process=updateFood&foodId=${food.foodId }"
					class="btn btn-primary">Update</a></td>
				<td><a
					href="FoodServlet?process=DeleteFood&foodId=${food.foodId }"
					class="btn btn-danger">Delete</a></td>

				<td></td>

				<%
				} 
				else if (login.equals("customer")) {%>
				<c:if test="${food.quantity!=0 }">
				<td><a class="btn btn-primary"
					href="CartServlet?process=addToCart&foodId=${food.foodId }">Add
  						to cart</</a></td>
  						</c:if>

				<%}%>
				<%}%>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>