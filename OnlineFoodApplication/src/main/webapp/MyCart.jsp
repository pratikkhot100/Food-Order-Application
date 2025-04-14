<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<script type="text/javascript" src="jquery-3.6.0.min.js"></script>

<script type="text/javascript">

function calculateSubtotal(element){
	$("#Orderbtn").hide();
	var cartId=element.id;
	var quantity=element.value;
	if(quantity<=0){
		
		element.value=1;
	}
	else{
		
		$.post("CartServlet", {
			"cartId":cartId, 
			"quantity":quantity,
			"process":"updateQuantity"	
		}, function(cartList){
			$("#cartDetails").empty();
			
			
			var arr=cartList.split("&&");
			var cArr=arr[0];
			var fArr=arr[1];
			
			var clist=JSON.parse(cArr);
			var flist=JSON.parse(fArr);
			 
			 for(var i=0; i<clist.length; i++){
				 
				document.getElementById("cartDetails").innerHTML+="<tr><td>"+clist[i].cartId+"</td><td>"+flist[i].fname+"</td><td><input class='price' value='"+flist[i].price+"' readonly='readonly'></td><td><input type='number' onchange='calculateSubtotal(this)' class='quantity' id='"+clist[i].cartId+"' value='"+clist[i].quantity+"'></td><td>"+(flist[i].price*clist[i].quantity)+"</td><td><a class='btn btn-danger' href='CartServlet?process=deleteCartItem&cartId="+clist[i].cartId+"'>Delete</a></td></tr>"; 
			}   
			 
			calculateTotal();
			$("#Orderbtn").show();
		});
		
		
	}
}
/*
 * , 
 */
function calculateTotal(){
	
	var priceArray=document.getElementsByClassName("price");
	var quantityArray=document.getElementsByClassName("quantity");
	
	var total=0;
	
	for(var i=0; i<priceArray.length; i++){
		
		total+=(priceArray[i].value*quantityArray[i].value);
	}
	
	$("#total").val(total);
}

$(function(){
	
	calculateTotal();
});
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Message.jsp"></jsp:include>
<form action="OrderServlet" method="post">
<input type="hidden" name="process" value="placeOrder">
<table  class="table table-success" style="text-align: center;">
<tr>
<td>Cart id</td>
<td>Name</td>
<td>Price per plate</td>
<td>No. of plates</td>
<td>Subtotal</td>
<td>Action</td>
</tr>

<tbody id="cartDetails">
<c:forEach var="cart" items="${cartList }">

<tr>
<td>${cart.cartId }</td>
<td>${cart.f.fname }</td>
<td><input value="${cart.price }" class="price"> </td>
<td><input type="number" class="quantity" max="${cart.f.quantity}" value="${cart.quantity }" id="${cart.cartId }" onchange="calculateSubtotal(this)"></td>
<td >${cart.subtotal}</td>
<td><a class="btn btn-warning" href="CartServlet?process=deleteCartItem&cartId=${cart.cartId}">Delete</a></td>
</tr>
</c:forEach>
</tbody>

<tr>
<td colspan="5" style="text-align: right"><input  type="text" name="billingAmount" style="text-align: right;" readonly="readonly" id="total">&nbsp;&nbsp; </td>
<td></td>
</tr>

<tr>
<td colspan="6" style="text-align: center;"><input type="submit" class="btn btn-success" id="Orderbtn" value="Place order"></td>

</tr>

</table>
</form>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>