<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li>
					<a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a>
				</li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
			</div>
			<br>
			<table class="table table-stripped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Login</th>
						<th>Password</th>
						<th>Role</th>
						<th>Activation</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUsers}">

						<tr>
							<td><c:out value="${user.idUser}" /></td>
							<td><c:out value="${user.login}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><c:out value="${user.role}" /></td>
							<td><c:out value="${user.enabled}" /></td>
							<td>
								<a href="edit?id=<c:out value='${user.idUser}' />">Edit</a>
									&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${user.idUser}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
