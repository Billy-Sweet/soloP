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
<title>${thisGame.name }</title>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

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
	<div class="container-fluid">
		<h2>Title: <c:out value="${thisGame.name }"/> </h2><br>
		<p>Added By:<c:out value="${thisGame.gameCreator.name}"/></p>
		<p>Genre: <c:out value="${thisGame.genre }"/> </p><br>
		<p>Rating: <c:out value="${thisGame.rating }"/></p><br>
		<p>Description: <c:out value="${thisGame.description}"/></p>
			<div class="container-fluid"><c:if test="${ loggedUser.id == thisGame.gameCreator.id}">
				<a href="/games/${thisGame.id }/edit" class="btn btn-outline-secondary">EDIT</a>
				<form action="/games/${thisGame.id }/delete" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete Game" class="btn btn-danger">
				</form>
			</c:if></div>
	</div>


</body>
</html>