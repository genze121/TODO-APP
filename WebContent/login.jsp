<%@page import="com.todo.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>Login Model</title>

<style type="text/css">
.text-design {
	font-family: galindo;
	font-size: 15px;
}

.text-implementation {
	font-family: galindo;
}

.text-increase {
	font-family: galindo;
	font-size: 15px;
}

.text-design-format {
	font-family: galindo;
}
</style>

</head>
<body
	style="background-color: #fef9e7; background-image: linear-gradient(315deg, #fef9e7 0%, #fddac5 74%);">
	<%@include file="all_Component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4">
					<div class="card-header">
						<h4 class="text-center text-implementation">
							<i class='fa fa-user-circle-o'></i> Login Model
						</h4>

						<%
							String error = (String) session.getAttribute("ErrorMssg");

							if (error != null) {
						%>

						<div class="alert alert-danger text-increase" role="alert">
							<%=error%>
						</div>
						<%
							session.removeAttribute("ErrorMssg");
							}
						%>

						<%
							String logout = (String) session.getAttribute("logoutMssg");
							if (logout != null) {
						%>
						<div class="alert alert-danger text-increase" role="alert">
							<%=logout%>
						</div>
						<%
							session.removeAttribute("logoutMssg");
							}
						%>
					</div>

					<div class="card-body">

						<form action="login" method="post">

							<div class="form-group text-design">
								<label for="exampleInputEmail1"> Username </label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									name="email_" aria-describedby="emailHelp"
									placeholder="Enter Username" required>
							</div>
							<div class="form-group text-design">
								<label for="exampleInputPassword1"> Password </label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="password_" placeholder="Password" required>
							</div>
							<div class="mt-4 text-design-format">
								<button type="submit"
									class="btn btn-success badge-pill btn-lg btn-block">Login</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="all_Component/footer.jsp"%>
</body>
</html>