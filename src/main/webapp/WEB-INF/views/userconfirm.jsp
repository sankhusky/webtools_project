<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${contextPath}/resources/bootstrap-3.4.1-dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="${contextPath}/resources/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <link href="${contextPath}/resources/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/bootstrap-3.4.1-dist/css/common.css" rel="stylesheet">
    
<title>Insert title here</title>
</head>
<body>
<form action="${contextPath}/user/regsuccess" style="width:600px; margin:50px auto" method="post">

	 <div class="form-group" >
	 	<label for="otp">Please enter the One Time Password received in your confirmation mail:</label> 
		<input class="form-control" type="text" id="otp" name="otp" placeholder="Enter OTP" />
		
		<input type="submit" class="btn btn-default" value="Confirm"/>
  </div>
	 	
	

</form>
</body>
</html>