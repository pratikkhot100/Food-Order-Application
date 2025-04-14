<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
      String msg=(String)request.getAttribute("msg");
      String errMsg=(String)request.getAttribute("errorMsg");
      
      if(msg!=null){
    	  %> 
    	  <h3 style="color: green;"> <%=msg %></h3> 
    	  <%}
    	     else if(errMsg!=null){%>
    	    	 
    	    	<h3 style="color: red;"> <%=errMsg %></h3> 
    	    	
    	     <%}%>

</body>
</html>