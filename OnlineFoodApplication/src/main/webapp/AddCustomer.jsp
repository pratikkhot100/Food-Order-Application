<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
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
	<form  onsubmit="return validate()" action="CustomerServlet" method="post">
	
	<table class="table table-success">
    <input type="hidden" name="process" value="addcustomer">
    <h2>Registration</h2>

    <tr>
        <th>Enter name:</th>
        <td><input id="name" type="text" class="form-control form-control-sm" name="cname" placeholder="Enter your name" required="required"><span id="in1" style="color:red;">*</span></td>
    </tr>
    <tr>
        <th>Enter Address:</th>
        <td><input type="text" class="form-control form-control-sm" name="address" placeholder="Enter your address" required="required"><span style="color:red;">*</span></td>
    </tr>
    <tr>
        <th>Enter Email:</th>
        <td><input type="email" class="form-control form-control-sm" name="email" placeholder="Enter your email" required="required"><span style="color:red;">*</span></td>
    </tr>
    <tr>
        <th>Enter ContactNo:</th>
        <td><input type="number" class="form-control form-control-sm" name="contactNo" placeholder="Enter your contact number" required="required"><span style="color:red;">*</span></td>
    </tr>
    <tr>
        <th>Enter Password:</th>
        <td><input type="password" class="form-control form-control-sm" name="password" placeholder="Enter your password" required="required"><span style="color:red;">*</span></td>
    </tr>
    <tr>
        <td><input type="reset" class="btn btn-danger" value="Clear"></td>
        <td><input class="btn btn-primary" type="submit" value="Register"></td>
    </tr>

</table>
	
	<jsp:include page="Footer.jsp"></jsp:include> 
	</form>
</body>
</html>