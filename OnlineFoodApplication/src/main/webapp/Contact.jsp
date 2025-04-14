<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">

body {
	margin-top: 20px;
}
h2 {
    text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="Message.jsp"></jsp:include>
	<form  onsubmit="return validate()" action="ContactServlet" method="post">
	
	<table class="table table-success">
    <input type="hidden" name="process" value="addcustomer">
    <h2>Contact Us</h2>

    <tr>
        <th>Enter name:</th>
        <td><input id="name" type="text" class="form-control form-control-sm" name="cname" placeholder="Enter your name" required="required"></td>
    </tr>
    <tr>
        <th>Enter Email:</th>
        <td><input type="email" class="form-control form-control-sm" name="email" placeholder="Enter your email" required="required"></td>
    </tr>
    <tr>
        <th>Enter Message:</th>
        <td><textarea class="form-control form-control-sm" name="message" placeholder="Enter your message" required="required"></textarea></td>
    </tr>
    <tr>
        <td><input type="reset" class="btn btn-danger" value="Clear"></td>
        <td><input class="btn btn-primary" type="submit" value="Submit"></td>
    </tr>

</table>
	
	<jsp:include page="Footer.jsp"></jsp:include> 
	</form>
</body>
</html>