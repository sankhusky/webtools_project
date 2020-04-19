<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Project</title>
</head>
<body>

<nav class="topnav">
  <a class="active" href="#dashboard">Dashboard</a>
  <a href="${contextPath}/dashboard/profile">Profile</a>
  <a href="${contextPath}/dashboard/about">About</a>
  <a href="${contextPath}/user/logout" class="logout">Logout</a>
  </nav> 
  
  <div id="createfab"><a href="${contextPath}/dashboard/createproject">Create Project</a></div>
  <%-- <button id="createfab" onclick="${contextPath}/dashboard/createproject" >Create</button>  <!--ADD THIS onclick="location.href='/register.htm'" value="Register" --> --%>
  
  
  <div class="create-form" >
  <form:form action = "${contextPath}/dashboard/createproject" method="POST" modelAttribute="projectData">
		
		Project Name: 
		<form:input path="projectName" />
		<form:errors path="projectName" cssStyle="color:red"/>
		<br>
		Description: 
		<form:textarea path="projectDescription" />
		<form:errors path="projectDescription" cssStyle="color:red"/>
		<br>
		Link:
		<form:input type="text" path="link"/>
				
		<br>
		
		
		<input type="submit" value="Create Project"/>
		
	</form:form> 
  
  </div>
</body>
</html>