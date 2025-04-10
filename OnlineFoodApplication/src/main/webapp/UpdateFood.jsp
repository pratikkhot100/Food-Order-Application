<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

 <script type="text/javascript">
     function changeCategory(element) {
		var c=element.value;
		if (c!=null && c!="click here to change category")
		{
			document.getElementById("in1").value=c;
		}
	
}
 </script>
</head>
<body>
            
             <jsp:include page="Header.jsp"></jsp:include>
             <jsp:include page="Message.jsp"></jsp:include>
             <form  onsubmit="return validate()" action="FoodServlet" method="post">
             <input type="hidden" name="process" value="UpdateFoodItem">
             <table  class="table table-success">
             
             <tr>
            <th > Id  : </th> <td><input type="text" id="fname" class="form-control form-control-sm"  id="iname" name="foodId" value="${foodObj.food_id }" readonly="readonly"><span style="color:red;">*</span></td>
             </tr>
              
              <tr>
            <th > Enter Food name  : </th> <td><input type="text" id="fname" class="form-control form-control-sm"  id="iname" name="fname" value="${foodObj.fname }"><span style="color:red;">*</span></td>
             </tr>
              
              <tr>
            <th> Enter Food Type  : </th> 
            
            <td>
                <select name="type" class="form-control form-control-sm" >
                <%
                ArrayList<String> types=new ArrayList();
                types.add("Veg");
                types.add("Non-Veg");
                pageContext.setAttribute("types", types);
                %>
               <c:forEach var="t" items="${types }">   
               <c:if test="${t.equals(foodObj.type) }">
               <option selected="selected" value="${foodObj.type }">${foodObj.type }</option>
               </c:if>
                
               <c:if test="${!t.equals(foodObj.type) }">
               <option value="${t }">${t}</option>
               </c:if>
               </c:forEach>            
                
                </select>
            </td>
             </tr>
             
 
             
               <tr>
            <th> Enter Food price : </th> <td><input   class="form-control form-control-sm"  name="price" value="${foodObj.price} " required="required"><span style="color:red;">*</span></td>
             </tr>
             
               <tr>
            <th> Enter Food Quantity : </th> <td><input type="number" class="form-control form-control-sm" value="${foodObj.quantity}"  name="quantity" required="required"><span style="color:red;">*</span></td>
             </tr>
             
               <tr>
            <th> Enter Food Category : </th> 
            <td>
              <input type="text" value="${foodObj.category }" id="in1" name="category" readonly="readonly">
              
              <select onchange="changeCategory(this)">
              <option>click here to change category</option>
              <option value="Fast food" >Fast food</option>
               <option value="Healty Snack">Healty Snack</option>
                <option value="Breakfast">Breakfast</option>
                 <option value="Main cource">Main cource</option>
             <option value="Sweet dish">Sweet dish</option>
              </select>
            </td>
             </tr>
             
               <tr>
            <th> Enter Food Description : </th> <td><input type="text" class="form-control form-control-sm"  name="description"  value="${foodObj.description}" required="required"><span style="color:red;">*</span></td>
             </tr>
             
               <tr>
            <th> Enter Food Rating : </th> <td><input type="number" class="form-control form-control-sm"  value="${foodObj.rating }" name="rating" required="required"><span style="color:red;">*</span></td>
             </tr>
             
             
               <tr>
            <td><input type="reset" class="btn btn-danger value="Clear"> </td> <td><input class="btn btn-primary"  type="submit" value="Update"></td>
             </tr>
             </table>
             </form>
             <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>