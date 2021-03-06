<%@ page language="java" contentType="text/html; charset=UTF-16" pageEncoding="UTF-16"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-16">
				<title>View All Employees</title>
			<meta charset="UTF-16">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"/>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" ></script>
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/additional-methods.js"></script>
		  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
		<link rel="stylesheet" href="https://cdn.datatables.net/v/dt/b-1.5.1/r-2.2.1/sl-1.2.5/datatables.min.css"  type="text/css"/>
		<link rel="stylesheet" href="/extensions/Editor/css/editor.dataTables.min.css" type="text/css"/>
	</head>
	<body>
		<div class="container-fluid col-md-7">
			<table id="table_id" class="table table-hover table-bordered table-striped table-hover table-condensed">
				<thead>
					<tr>
						<th><b>First name</b></th>
						<th><b>last name</b></th>
						<th><b>email</b></th> 
					</tr>
				</thead>
				<tbody>
				<c:forEach var="emp" items="${employees}">
						<tr>
							<td>${emp.firstname}</td>
							<td>${emp.lastname}</td>
							<td>${emp.email}</td>
							<td>${emp.photo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
	<script>
	    $(document).ready(function () {
	        $("#table_id").DataTable({
	        	"pageLength": 10
	        });
	    });
</script>
</html>