<%@ page language="java" contentType="text/html; charset=UTF-16" pageEncoding="UTF-16"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-16">
			<title>Employee Views</title>
		<meta charset="UTF-16">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"/>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js" ></script>
</head>
<body>
	<div class="container-fluid">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th><b>First name</b></th>
					<th><b>last name</b></th>
					<th><b>email</b></th>
					<th><b>Photo</b></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${employee.firstname}</td>
					<td>${employee.lastname}</td>
					<td>${employee.email}</td>
					<td>${employee.photo}</td>
				</tr>
			</tbody>
		</table>
		<sec:authorize access="hasRole('ADMIN')">
		<button id="btn" type="button" class="btn btn-primary" onclick="location.href='viewAll'"><spring:message code="reg.label.viewAll" text="View All users"></spring:message></button>
		</sec:authorize>
	</div>
</body>
</html>