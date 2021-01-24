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
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<div>
					<h2>
						<c:if test="${user != null}"> Edit User </c:if>
						<c:if test="${user == null}"> Add New User </c:if>
					</h2>
				</div>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.idUser}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Login</label> <input type="text"
						value="<c:out value='${user.login}' />" class="form-control"
						name="login" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password">
				</fieldset>

				<fieldset class="form-group">
					<label>Role</label> <input type="text"
						value="<c:out value='${user.role}' />" class="form-control"
						name="role">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Activation</label> <input type="text"
						value="<c:out value='${user.enabled}' />" class="form-control"
						name="activation">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
