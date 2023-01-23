<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Current Games</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand  font-size-base * 2;">Board Game Bar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/games/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown link
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<h1> Welcome, <c:out value="${loggedUser.name }" /> </h1><br>
<a href= "/games/new" class="btn btn-primary">Create New Game</a>
<a href="/logout" class = "btn btn-primary"> Log Out</a>


	<div class="container-fluid">
		<table class="table table-striped">
		<thead>
			<tr>
				<th>Name:</th>
				<th>Genre:</th>
				<th>Rating:</th>
				<th>Description</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="game" items="${games}">
				<tr>
				<td><a href="/games/${game.id }"><c:out value="${game.name}"/></a></td>
				<td><c:out value="${game.genre}"/></td>
				<td><c:out value="${game.rating }"/></td>
				<td><c:out value="${game.description}"/></td>
				<td> 
					<a href ="/games/${game.id }">View More Info</a>
				</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</body>
</html>