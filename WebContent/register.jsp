<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>Registration Model</title>

<style type="text/css">
.text-design {
	font-family: galindo;
	font-size: 17px;
}

.text-implementation {
	font-family: galindo;
}

.text-increase {
	font-family: galindo;
	font-size: 15px;
}
</style>

</head>
<body
	style="background-color: #306844; background-image: linear-gradient(314deg, #306844 0%, #2c4c3b 74%);">
	<%@include file="all_Component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-2">
					<div class="card-header">
						<h4 class="text-center text-implementation">
							<i class='fa fa-user-plus'></i> Registration Model
						</h4>

						<%
							String checkbox = (String) session.getAttribute("CheckboxMssg");
							String success = (String) session.getAttribute("SuccessMssg");
							String error = (String) session.getAttribute("ErrorMssg");

							if (checkbox != null) {
						%>
						<div class="alert alert-danger text-increase" role="alert">
							<%=checkbox%>
						</div>
						<%
							session.removeAttribute("CheckboxMssg");
							}

							if (success != null) {
						%>
						<div class="alert alert-success text-increase" role="alert">
							<%=success%>
							Please Login Here <a href="login.jsp"> Login </a>
						</div>
						<%
							session.removeAttribute("SuccessMssg");
							}
							if (error != null) {
						%>

						<div class="alert alert-danger" role="alert">
							<%=error%>
						</div>
						<%
							session.removeAttribute("ErrorMssg");
							}
						%>

					</div>

					<div class="card-body">

						<form action="register" method="post">
							<div class="form-group text-design">
								<label for="exampleInputFirst1">First Name</label> <input
									type="text" class="form-control" id="exampleInputFirst1"
									name="first_name" placeholder="Enter First Name" required>
							</div>

							<div class="form-group text-design">
								<label for="exampleInputLast1">Last Name</label> <input
									type="text" class="form-control" id="exampleInputLast1"
									name="last_name" placeholder="Enter Last Name" required>
							</div>

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
							<div class="form-group form-check text-design">
								<input type="checkbox" class="form-check-input" name="checkbox"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1"> I agree the terms and conditions </label>
							</div>
							<button type="submit" class="btn btn-danger badge-pill btn-block">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="all_Component/footer.jsp"%>
</body>
</html>