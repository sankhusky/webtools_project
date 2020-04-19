<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

   <%--  <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> --%>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<h2>Register User</h2>

<div class="container">

	<form:form action = "${contextPath}/user/register" method="POST" modelAttribute="userData">
		
		Username: 
		<form:input path="userName" />
		<form:errors path="userName" cssStyle="color:red"/>
		<br>
		Email: 
		<form:input path="email" />
		<form:errors path="email" cssStyle="color:red"/>
		<br>
		
		<label for="userType">User Type:</label>
		
		<select id="userType">
		
		  <option value="student">Student</option>
		  <option value="instructor">Course Instructor</option>
		  <option value="ta">Teacher's Assistant</option>
		  
		  	<%-- <form:options items="${userTypeList}"/> --%>
		  			  
		</select> 
		<%-- <form:errors path="userType" cssStyle="color:red"/> --%>
		<br>
		Password:
		<form:input path="password"/>
		<form:errors path="password" cssStyle="color:red"/>
		<br>
		Confirm Password:
		<form:input path="passwordConfirm"/>
		<form:errors path="passwordConfirm" cssStyle="color:red"/>
		<br>
		
		
		<input type="submit" value="Register User"/>
		
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