<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
          <jsp:include page="Header.jsp"></jsp:include>
             <jsp:include page="Message.jsp"></jsp:include>
             <form   action="CustomerServlet" method="post">
             <input type="hidden" name="process" value="UpdateCustomerDetails">
             <table  class="table table-success" style="text-align: center;">
	       <tr>
	       <td> Id :</td><td><input type="text" name="cusId" value="${custObj.cusId }" readonly="readonly"></td>
	       
	       </tr>
              <tr>
            <th > Enter name  : </th> <td><input id="name" type="text"   value="${custObj.cname }" class="form-control form-control-sm"   name="cname"></td>
             </tr>
               <tr>
            <th > Enter Address  : </th> <td><input type="text" value="${custObj.address }"  class="form-control form-control-sm"   name="address"></td>
             </tr>
               <tr>
            <th > Enter Email  : </th> <td><input type="email" value="${custObj.email }"  class="form-control form-control-sm"   name="email" readonly="readonly"></td>
             </tr>
                <tr>
            <th > Enter ContactNo  : </th> <td><input type="number"  value="${custObj.contactNo }"  class="form-control form-control-sm"   name="contactNo"></td>
             </tr>
                <tr>
            <th > Enter Password  : </th> <td><input type="password"  value="${custObj.password }" class="form-control form-control-sm"   name="password"></td>
             </tr>
	          <tr>
            <td><input type="reset" class="btn btn-danger" value="Clear"> </td> <td><input class="btn btn-primary"  type="submit" value="Update"></td>
             </tr>
	
             </table>
             </form>
             <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>