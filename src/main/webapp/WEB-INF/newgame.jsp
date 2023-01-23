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
<title>Add a Game</title>
<meta charset="ISO-8859-1">
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



<div class="mx-auto" style="width: 90%;">
<h1> Add A Game</h1>
	<div class="col">
	<form:form action="/games/new" method="post" modelAttribute= "newGame">
			<p>
				<form:label path="name">Name: </form:label><br>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="genre">Genre: </form:label><br>
				<form:errors path="genre"/>
				<form:input path="genre"/>
			</p>
			<p> 
			<form:label path="rating">Rating:</form:label>
			<form:select path="rating">
				<c:forEach var="thisRating"	items="${possibleRatings }">
					<form:option value="${thisRating }" label="${thisRating }"/>
					</c:forEach>
					
				</form:select>
				<form:errors path="rating"	class="text-danger offset-2"/>
			</p>
			<p>
				<form:label path="description">Description: </form:label><br>
				<form:errors path="description"/> 
				<form:textarea path="description" rows ="5" cols ="30"/>
			</p>
			<form:input type="hidden" path="gameCreator" value="${thisUser.id }"/>
			<input type="submit" class="btn btn-primary offset - 2 col -2" value="Add Game">
	</form:form>
	</div>
</div>

	

</body>
</html>