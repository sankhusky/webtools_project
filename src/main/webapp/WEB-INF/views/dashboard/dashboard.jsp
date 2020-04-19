<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<!-- <nav class="navbar navbar-expand-lg navbar-light bg-light">
 -->

 <%-- <nav class=""navbar navbar-expand-lg navbar-light bg-light"">
  <a class="active" href="#dashboard">Dashboard</a>
  <a href="${contextPath}/dashboard/profile">Profile</a>
  <a href="${contextPath}/dashboard/about">About</a>
  <a href="${contextPath}/user/logout" class="logout">Logout</a>
  </nav>  --%>
  
  <ul class="nav nav-pills">
  <li role="presentation" class="active"><a href="#">Dashboard</a></li>
  <li role="presentation"><a href="${contextPath}/dashboard/profile">Profile</a></li>
  <li role="presentation"><a href="${contextPath}/dashboard/about">About</a></li>
  <li role="presentation"><a href="${contextPath}/dashboard/createproject">Create a new Project</a></li>
  <li role="presentation"><a href="${contextPath}/user/logout">Logout</a></li>
</ul>
  
  <%-- <div id="createfab"><a href="${contextPath}/dashboard/createproject">Create Project</a></div>
  <button id="createfab" onclick="${contextPath}/dashboard/createproject" >Create</button>  <!--ADD THIS onclick="location.href='/register.htm'" value="Register" -->
   --%>
  
  <c:forEach items="${projectList}" var="item">
    

	<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">${item.projectName}</h3>
  </div>
  <div class="panel-body">
  <div class="username"> ${item.getUser().getUserName() }</div> <!-- userName --> 	
    <div class="timestamp">Created ${item.createdOn }</div> <!-- "Created" + project's created date -->
  		<p class="description">${item.projectDescription}</p> <!-- project description -->
  </div>
  
   <div class="panel-footer"><div class="stars"> ${item.getStars() }</div>
  			<div class=comments><%--  ${item.getComments().size() }  --%>Comment</div></div>
</div>

  
 <%--  <div class="post-container-outer">
  	<img alt="" src=""></img>   <!-- DP -->
  	<div class="username"> ${item.getUser().getUserName() }</div> <!-- userName --> 	
  	<div class="post-container-inner">
  		<h3>${item.projectName} </h3> <!-- Title of Project -->
  		<div class="timestamp">Created ${item.createdOn }</div> <!-- "Created" + project's created date -->
  		<p class="description">${item.projectDescription}</p> <!-- project description -->
  		
  		<div class="post-bottom">
  		
  			<div class="stars"> ${item.getStars() }</div>
  			<div class=comments> ${item.getComments().size() } Comment</div>
  		
  		</div>
  	</div>
  </div> --%>
  </c:forEach>

</body>
</html>