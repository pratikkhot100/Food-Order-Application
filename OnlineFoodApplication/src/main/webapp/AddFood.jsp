<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
h2 {
    text-align: center;
}s
</style>
<meta charset="UTF-8">
<title>Add Food</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

 <script type="text/javascript">
 
    function validateform() {
    	    var name=document.getElementById("fname");
    	     	      
    	    if (name.value=="")
    	    {  
    	      document.getElementById("s1").innerHTML="name is to short";
    	      return false;  
    	    }
    	    else {
				return true;
			}
    }
		
	
    
 </script>
</head>
<body>
            
             <jsp:include page="Header.jsp"></jsp:include>
             <jsp:include page="Message.jsp"></jsp:include>
             <form  name="myform" onsubmit="return validate()" action="FoodServlet" method="post">
             <input type="hidden" name="process" value="addFood">
             
             <table  class="table table-success">
              <h2>Add Food</h2>
             
              <tr>
            <th > Enter Food name  : </th> <td><input type="text" id="fname" class="form-control form-control-sm"  id="iname" name="fname"><span  id="s1" style="color:red;">*</span></td>
             </tr>
              
              <tr>
            <th> Enter Food Type  : </th> 
            
            <td>
                <select name="type" class="form-control form-control-sm" >
                <option value="Veg">Veg</option>
                <option value="Non-Veg">Non-Veg</option>
                
                </section>
            </td>
             </tr>
             
 
             
               <tr>
            <th> Enter Food price : </th> <td><input  class="form-control form-control-sm"  name="price" required="required"><span style="color:red;">*</span></td>
             </tr>
             
               <tr>
            <th> Enter Food QuaAddntity : </th> <td><input type="number" class="form-control form-control-sm" onblur="validate(this)"   name="quantity" required="required"><span style="color:red;">*</span></td>
             </tr>
             
               <tr>
            <th> Enter Food Category : </th> 
            <td>
              <select name="category" class="form-control form-control-sm"  >
              <option value="Fast food" >Fast food</option>
               <option value="Healty Snack">Healty Snack</option>
                <option value="Breakfast">Breakfast</option>
                 <option value="Main cource">Main cource</option>
             <option value="Sweet dish">Sweet dish</option>
              </select>
            </td>
             </tr>
             
               <tr>
            <th> Enter Food Description : </th> <td><input type="text" class="form-control form-control-sm" onblur="validate(this)" name="description" required="required"><span style="color:red;">*</span></td>
             </tr>
             
               <tr>
            <th> Enter Food Rating : </th> <td><input type="number" class="form-control form-control-sm"  value="5" name="rating" required="required"><span style="color:red;">*</span></td>
             </tr>
             
             
               <tr>
            <td><input type="reset" class="btn btn-danger value="Clear"> </td> <td><input onclick="validateform()" class="btn btn-primary"  type="submit" value="Add"></td>
             </tr>
             </table>
             </form>
             <jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>