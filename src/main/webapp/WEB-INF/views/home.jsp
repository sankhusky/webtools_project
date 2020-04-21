<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="${contextPath}/resources/bootstrap-3.4.1-dist/css/bootstrap.min.css">
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

<title>Log in with your account</title>


</head>

<body>
	<h1 align="center">Welcome to the Projects Repository!</h1>
	<div class="login-form" style="width: 340px; margin: 50px auto;">

		<form method="POST" action="${contextPath}/user/login"
			class="form-signin">
			<h2 class="text-center">Log in</h2>

			<div class="form-group">
				<span>${message}</span> <input name="userName" type="text"
					class="form-control" placeholder="Username" autofocus="autofocus" />

			</div>

			<div class="form-group">
				<input name="password" type="password" class="form-control"
					placeholder="Password" /> 
			</div>

		<%-- 	<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> --%>

			<div class="form-group">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log
					In</button>
			</div>
			<h4 class="text-center">
				<a href="${contextPath}/user/register">Create an account</a>
			</h4>

		</form>

	</div>
	
	
	
	<c:choose>
  <c:when test="${empty error}">
  	<div class="alert alert-info alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Hi!</strong>Please Enter your credentials!
</div>
  
  </c:when>

  <c:otherwise>
	
	<div class="alert alert-danger alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>Error!</strong> ${errorMsg}
	</div>
  </c:otherwise>
 </c:choose>
	
	
	<!-- /container -->
	<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>
</body>
</html>