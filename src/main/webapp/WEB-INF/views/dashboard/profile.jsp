<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
response.setHeader("pragma", "no-cache");              
response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");             
response.setHeader("Expires", "0"); 
%>
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
    
    
<title>${sessionScope.user.getUserName()}-Details</title>
</head>
<body>
  <ul class="nav nav-pills">
  <li role="presentation" ><a href="${contextPath}/dashboard/">Dashboard</a></li>
  <li role="presentation" class="active"><a href="${contextPath}/dashboard/profile">Profile</a></li>
  <li role="presentation"><a href="${contextPath}/dashboard/about">About</a></li>
  <li role="presentation"><a href="${contextPath}/dashboard/createproject">Create a new Project</a></li>
  <li role="presentation"><a href="${contextPath}/user/logout">Logout</a></li>
</ul>
<div class="jumbotron" style="width: 600px; margin: 50px auto; padding: 50px;" >
  <h1>${sessionScope.user.getUserName()}</h1>
  <br>
  <ul class="list-group">
  <li class="list-group-item">
    <h2>${userTypes.get(sessionScope.userTypeId)}</h2> 
     
      
     
  </li>
  <li class="list-group-item">
     Email Id : ${sessionScope.user.getEmail()}
  </li>
  <li class="list-group-item">
    <span class="badge">${projectCount}</span>
    Projects
  </li>
  <li class="list-group-item">
     Joined on : ${sessionScope.user.getCreatedOn()}
  </li>
</ul>
  <!-- <p><a class="btn btn-primary btn-lg" href="#" role="button">Edit</a></p> TODO Later -->
</div>
</body>
</html>