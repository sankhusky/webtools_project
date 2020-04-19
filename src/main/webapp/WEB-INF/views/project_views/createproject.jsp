<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="${contextPath}/resources/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
<link
	href="${contextPath}/resources/bootstrap-3.4.1-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${contextPath}/resources/bootstrap-3.4.1-dist/css/common.css"
	rel="stylesheet">
<title>Create a new Project</title>
</head>
<body>

	<ul class="nav nav-pills">
		<li role="presentation"><a href="${contextPath}/dashboard/">Dashboard</a></li>
		<li role="presentation"><a
			href="${contextPath}/dashboard/profile">Profile</a></li>
		<li role="presentation"><a href="${contextPath}/dashboard/about">About</a></li>
		<li role="presentation" class="active"><a
			href="${contextPath}/dashboard/createproject">Create a new
				Project</a></li>
		<li role="presentation"><a href="${contextPath}/user/logout">Logout</a></li>
	</ul>

	<%-- <div class="create-form">
		<form:form action="${contextPath}/dashboard/createproject"
			method="POST" modelAttribute="projectData">
		
		Project Name: 
		<form:input path="projectName" />
			<form:errors path="projectName" cssStyle="color:red" />
			<br>
		Description: 
		<form:textarea path="projectDescription" />
			<form:errors path="projectDescription" cssStyle="color:red" />
			<br>
		Link:
		<form:input type="text" path="link" />

			<br>


			<input type="submit" value="Create Project" />

		</form:form> --%>


<%-- <div class="well" style="width: 600px; margin: 50px auto">
		<form:form action="${contextPath}/dashboard/createproject"
			method="POST" modelAttribute="projectData">
			<div class="input-group">
			Project Name:
				<form:input path="projectName" type="text" class="form-control" placeholder="Username"
					aria-describedby="basic-addon1"/>
					<form:errors path="projectName" cssStyle="color:red" />
			<br>
			</div>

			<div class="input-group">
				Description: 
		<form:textarea path="projectDescription" class="form-control"
					aria-describedby="basic-addon1"/>
						<form:errors path="projectDescription" cssStyle="color:red" />
			<br>		
			</div>

			<div class="input-group">
				Link:
		<form:input type="text" path="link"
					class="form-control" aria-describedby="basic-addon1"/>				
			</div>

<div class="input-group">
		<input type="submit" class="btn btn-primary btn-lg" value="Create Project" />
</div>
		</form:form>
</div> --%>




<form:form action="${contextPath}/dashboard/createproject"
			method="POST" modelAttribute="projectData" style="width: 600px; margin: 50px auto">
			
			<div class="form-group">
			 <label for="projectName">Project Name</label>
			<form:input path="projectName" type="text" class="form-control" placeholder="Project Name" id="projectName"
					aria-describedby="basic-addon1"/>
					<form:errors path="projectName" cssStyle="color:red" />
			</div>
			
  <div class="form-group">
  
 <label for="description">Description</label> 
		<form:textarea path="projectDescription" class="form-control" rows="3" 
					aria-describedby="basic-addon1" id="description"/>
						<form:errors path="projectDescription" cssStyle="color:red" />
    
    
  </div>
  
  <div class="form-group">
  
   <label for="link">Link</label>
		<form:input id="link" type="text" path="link"
					class="form-control" aria-describedby="basic-addon1"/>		
      
    
  </div>
 <input type="submit" class="btn btn-default" value="Create Project" />
  
</form:form>



	
</body>
</html>