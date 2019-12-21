<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Suivis des colis</title>
	<link rel="stylesheet" href="css/base.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="home">Accueil</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="EnregistrerColis.html">Enregistrer Colis</a>
			</li>
		</ul>
	</div>
</nav>

<div class="container">
<h1>Suivis Colis</h1>
<table class="table">
	<thead class="thead-dark">
	<tr>
		<th>N° Colis</th>
		<th>Poids</th>
		<th>Origine</th>
		<th>Desination</th>
		<th>Colis délivré ?</th>
	</tr>
	</thead>

	<tr>
		<td>${colis.id}</td>
		<td>${colis.poids}</td>
		<td>${colis.origine}</td>
		<td>${colis.destination}</td>
		<c:choose>
			<c:when test="${colis.delivrer == true}">
				<td class="p-3 mb-2 bg-success text-white">${colis.delivrer}</td>
			</c:when>
			<c:otherwise>
				<td>${colis.delivrer}</td>
			</c:otherwise>


		</c:choose>
	</tr>
</table>



	<c:if test = "${colis.delivrer == false}">
		<hr/>
		<h3>Changer état colis</h3>
		<form action="postTrack" method="post" class="form-group">
			location: <input type="text" name="location" class="form-control">
			<input name="id" type="hidden" value="${colis.id}">

			<select name="status" class="form-control">
				<c:forEach items="${states}" var="status">
					<option>${status}</option>
				</c:forEach>
			</select>
			<input class="btn btn-primary" type="submit" value="Change location">
		</form>

		<hr/>
		<h3>Colis délivré</h3>
		<form action="delivrer" method="post" class="form-group">
			<input name="id" type="hidden" value="${colis.id}">
			<input class="btn btn-success" type="submit" value="delivrer" class="form-control">
		</form>
	</c:if>

	<hr/>
<h3>Historique du colis</h3>
<table class="table">
	<thead class="thead-dark">
	<tr>
		<th>Date</th>
		<th>Localisation</th>
		<th>Status</th>
	</tr>
	</thead>
	<c:forEach items="${colis.suivis}" var="suivis">
		<tr>
			<td>${suivis.date}</td>
			<td>${suivis.localisation}</td>
			<td>${suivis.status}</td>
		</tr>

	</c:forEach>
</table>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
