<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${contextPath}/resources/bootstrap-3.4.1-dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="${contextPath}/resources/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
    <link href="${contextPath}/resources/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/bootstrap-3.4.1-dist/css/common.css" rel="stylesheet">
    
    <title>Create an account</title>
</head>

<body>

<h2 align="center" style="margin=60px;">Register User</h2>

<form:form action = "${contextPath}/user/register" method="POST" modelAttribute="userData" style="width:600px; margin:50px auto">
  <div class="form-group" >
  <label for="userName">Username:</label> 
		<form:input path="userName" class="form-control" type="text" id="userName" placeholder="User Name" />
		<form:errors path="userName" cssStyle="color:red"/>
  </div>
  
   
		
		
  <div class="form-group">
    <label for="email">Email address</label>
    <form:input  path="email" type="email" class="form-control" id="email" placeholder="Email"/>
    <form:errors path="email" cssStyle="color:red"/>
  </div>
  		
		
		<div class="form-group">
		<label for="userType">User Type</label>
		<form:select path="userType" class="form-control">
		
		 <%--  <form:option value="student">Student</form:option>
		  <form:option value="instructor">Course Instructor</form:option>
		  <form:option value="ta">Teacher's Assistant</form:option> --%>
		  
		  	<form:options items="${userTypeList}"/>
		  			  
		</form:select> 
		<form:errors path="userType" cssStyle="color:red"/>
		</div>
		
  <div class="form-group">
    <label for="password">Password</label>
    <form:input path="password" type="password" class="form-control" id="password" placeholder="Password"/>
    <form:errors path="password" cssStyle="color:red"/>
  </div>
  
  <div class="form-group">
  <label for="confirmPassword">Confirm Password</label>
  <form:input path="passwordConfirm" type="password" class="form-control" id="confirmPassword" placeholder="Password"/>
	<form:errors path="passwordConfirm" cssStyle="color:red"/>
	</div>
	  
  <input type="submit" class="btn btn-default" value="Register User"/>
  
</form:form>


<%--     <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
 --%>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<%-- <script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>
</body>
</html>