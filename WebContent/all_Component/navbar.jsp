<%@page import="com.todo.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="allComponent.jsp"%>
<title>Todo Notes App</title>
<style type="text/css">
.text-design {
	font-family: galindo;
	font-size: 25px;
	text-shadow: 1px 1px #ff0000;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-warning">
		<a class="navbar-brand" href="index.jsp"> <i
			class='fa fa-address-book'></i> Todo App
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp"><i class='fa fa-home'></i> Home <span
						class="sr-only">(current)</span> </a></li>
				<li class="nav-item active"><a class="nav-link" href="addTodo.jsp"> <i
						class='fa fa-plus-square'></i> Add Todo Notes
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="viewTodo.jsp"> <i
						class='fa fa-eye'></i> View Todo Notes
				</a></li>

			</ul>
			<%
				User user = (User) session.getAttribute("user");
				if (user == null) {
			%>
			<form class="form-inline my-2 my-lg-0">
				<a href="login.jsp" class="btn btn-success btn-lg"> <i
					class='fa fa-user-circle'></i> Login
				</a> <a href="register.jsp" class="btn btn-danger ml-2 btn-lg"> <i
					class='fa fa-user-plus'></i> Register
				</a>
			</form>

			<%
				} else {
			%>
			<form class="form-inline my-2 my-lg-0">
				<a class="btn btn-success btn-lg"><i class='fa fa-user-circle'></i>
					<%=user.getFirstname() + " " + user.getLastname()%> </a> <a
					class="btn btn-danger btn-lg ml-2" data-toggle="modal"
					data-target="#exampleModal"><i class='fa fa-power-off'></i>
					Logout </a>
			</form>
			<%
				}
			%>

		</div>

		<!-- Logout Popup -->

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title text-design" id="exampleModalLabel">Logout
							Modal</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center">
						<h2 class="text-design">Do you want to logout?</h2>
						<div class="mt-4">
							<button type="button" class="btn btn-secondary btn-lg"
								data-dismiss="modal">Close</button>
							<a href="logout" type="button" class="btn btn-danger btn-lg">Logout</a>
						</div>

					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<!-- Logout Popup -->
	</nav>

</body>
</html>