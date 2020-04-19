<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/styles/dashboard.css" />" rel="stylesheet">
<title>Insert title here</title>
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
  
  
  <c:forEach items="${projectList}" var="item">
    

  
  <div class="post-container-outer">
  	<img alt="" src=""></img>   <!-- DP -->
  	<div class="username"> ${item.getUser().getUserName() }</div> <!-- userName --> 	
  	<div class="post-container-inner">
  		<h3>${item.projectName} </h3> <!-- Title of Project -->
  		<div class="timestamp">Created ${item.createdOn }</div> <!-- "Created" + project's created date -->
  		<p class="description">${item.projectDescription}</p> <!-- project description -->
  		
  		<div class="post-bottom">
  		
  			<div class="stars"> ${item.getStars() }</div>
  			<div class=comments><%--  ${item.getComments().size() }  --%>Comment</div>
  		
  		</div>
  	</div>
  </div>
  </c:forEach>

</body>
</html>