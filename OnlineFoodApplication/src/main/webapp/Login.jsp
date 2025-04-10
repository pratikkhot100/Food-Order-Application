<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
h2 {
    text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 
</head>
<body>
          <jsp:include page="Header.jsp"></jsp:include>
          
          <form action="LoginServlet" method="post">
          <input type="hidden" name="process" value="LoginPage">
          <table class="table table-success" style="text-align: center;">
           <h2>Login</h2>
           
          <tr>
          <th>Enter username : </th><td><input type="text"  class="form-control form-control-sm" placeholder="Your resister email id" name="username" required="required"></td>
          </tr>
          
           <tr>
          <th>Enter passwprd : </th><td><input type="password"  class="form-control form-control-sm" placeholder="Enter password" name="password"></td>
          </tr>
         
           <tr>
           <td><input type="reset" class="btn btn-danger" value="Clear"> </td> <td><input class="btn btn-primary"  type="submit" value="Login" required="required"></td>
           </tr>
          </table>
          <jsp:include page="Footer.jsp"></jsp:include> 
          </form>  
</body>
</html>