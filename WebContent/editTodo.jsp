<%@page import="com.todo.model.TodoDAO"%>
<%@page import="com.todo.entity.Todo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>Edit Todo Notes</title>

<style type="text/css">
.text-design1 {
	font-family: galindo;
}
</style>

</head>
<body
	style="background-color: #00bfb2; background-image: linear-gradient(315deg, #00bfb2 0%, #028090 74%);">
	<%@include file="all_Component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header">
						<h4 class="text-center text-implementation">
							<i class='fa fa-edit'></i> Edit Todo Notes
						</h4>
					</div>

					<div class="card-body">

						<form action="editTodo" method="post">
							<%
								int todoId = Integer.parseInt(request.getParameter("todoId"));
								TodoDAO todoDAO = new TodoDAO();
								Todo todo = todoDAO.getTodosById(todoId);
							%>


							<%
								if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userId">
							<%
								}
							%>

							<%
								if (todo != null) {
							%>
							<input type="hidden" value="<%=todo.getId()%>" name="todoId">
							<%
								}
							%>

							<div class="form-group text-design1">
								<label for="exampleInputTitle1">Todo Title</label> <input
									type="text" class="form-control" id="exampleInputTitle1"
									value="<%=todo.getTitle()%>" name="title"
									placeholder="Enter Title">
							</div>

							<div class="form-group text-design1">
								<label for="exampleFormControlSelect1">Todo Status</label> <select
									class="form-control" id="exampleFormControlSelect1"
									value="<%=todo.isStatus()%>" name="status">
									<option value="False">In Progress</option>
									<option value="True">Completed</option>
								</select>
							</div>

							<div class="form-group text-design1">
								<label for="exampleInputEmail1"> Username </label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									value="<%=todo.getUsername()%>" name="email_"
									aria-describedby="emailHelp" placeholder="Enter Username">
							</div>

							<div class="form-group text-design1">
								<label for="exampleFormControlTextarea1">Description</label>
								<textarea class="form-control" id="exampleFormControlTextarea1"
									name="description" placeholder="Description...." rows="3"><%=todo.getDescription()%></textarea>
							</div>

							<div class="text-design1">
								<button type="submit"
									class="btn btn-dark btn-lg badge-pill btn-block">Edit
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