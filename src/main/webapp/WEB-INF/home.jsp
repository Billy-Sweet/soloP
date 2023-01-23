<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page </title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
	 	<h1>Welcome</h1>
	 	<div class="row">
	 		<div class="col">
	 			<p class="fs-3">Register</p>
	 			<form:form action="/register" method="post" modelAttribute = "registerUser">
	 				<div class="row my-4">
	 					<form:label path="name" class="col-3"> Name: </form:label>
	 					<form:input path="name" class="col-8"/>
	 					<form:errors path="name" class="text-danger offset-3"/>
	 				</div>
	 				<div class="row my-4">
	 					 <form:label path="email" class="col-3"> Email: </form:label>
	 					<form:input path="email" class="col-8" type="email"/>
	 					<form:errors path="email" class="text-danger offset-3"/>
	 				</div>
	 				<div class="row my-4">
	 					 <form:label path="password" class="col-3"> Password: </form:label>
	 					<form:password path="password" class="col-8" />
	 					<form:errors path="password" class="text-danger offset-3"/>
	 				</div>
	 				<div class="row my-4">
	 					 <form:label path="confirmedPassword" class="col-3"> Confirm Password: </form:label>
	 					<form:password path="confirmedPassword" class="col-8"/>
	 					<form:errors path="confirmedPassword" class="text-danger offset-3"/>
	 				</div>
	 				<div class="row">
	 					<input type="submit" class="btn btn-primary offset-3 col-3" value= "Register" />
	 				</div>
	 			</form:form>
	 		</div>
	 		<div class="col">
	 			<p class="fs-3"> Login</p>
	 			<form:form action="/login" method="post" modelAttribute ="loginUser">
	 				 				<div class="row my-4">
	 					 <form:label path="LoginEmail" class="col-3"> Email: </form:label>
	 					<form:input path="LoginEmail" class="col-8" type="email"/>
	 					<form:errors path="LoginEmail" class="text-danger offset-3"/>
	 				</div>
	 				<div class="row my-4">
	 					 <form:label path="LoginPassword" class="col-3"> Password: </form:label>
	 					<form:password path="LoginPassword" class="col-8" />
	 					<form:errors path="LoginPassword" class="text-danger offset-3"/>
	 				</div>
	 				<input type ="submit" class="btn btn-primary offset-3 col-3" value="Login"/>
	 			</form:form>
	 		</div>
	 	</div>
	</div>
</body>
</html>