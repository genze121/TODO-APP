<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>Add Todo Notes</title>

<style type="text/css">
.text-design1 {
	font-family: galindo;
	font-size: 20px;
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
	style="background-color: #4062bb; background-image: linear-gradient(316deg, #4062bb 0%, #5200ae 74%);">
	<%@include file="all_Component/navbar.jsp"%>
	<%
		if (user == null) {
			session.setAttribute("ErrorMssg", "Please login...");
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header">
						<h4 class="text-center text-implementation">
							<i class='fa fa-sticky-note'></i> Add Todo Notes
						</h4>
						<%
							String success = (String) session.getAttribute("SuccessMssg");
							String error = (String) session.getAttribute("ErrorMssg");

							if (success != null) {
						%>
						<div class="alert alert-success" role="alert">
							<%=success%>
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

						<form action="addTodo" method="post">
							<%
								if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userId">
							<%
								}
							%>


							<div class="form-group text-design1">
								<label for="exampleInputTitle1">Todo Title</label> <input
									type="text" class="form-control" id="exampleInputTitle1"
									name="title" placeholder="Enter Title">
							</div>

							<div class="form-group text-design1">
								<label for="exampleFormControlSelect1">Todo Status</label> <select
									class="form-control" id="exampleFormControlSelect1"
									name="status">
									<option value="False">In Progress</option>
									<option value="True">Completed</option>
								</select>
							</div>

							<div class="form-group text-design1">
								<label for="exampleInputEmail1"> Username </label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									name="email_" aria-describedby="emailHelp"
									placeholder="Enter Username">
							</div>

							<div class="form-group text-design1">
								<label for="exampleFormControlTextarea1">Description</label>
								<textarea class="form-control" id="exampleFormControlTextarea1"
									name="description" placeholder="Description...." rows="3"></textarea>
							</div>

							<div class="text-design1">
								<button type="submit"
									class="btn btn-primary btn-lg badge-pill btn-block">Add
									Notes</button>
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