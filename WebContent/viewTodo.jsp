<%@page import="com.todo.model.TodoDAO"%>
<%@page import="com.todo.entity.Todo"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="all_Component/allComponent.jsp"%>
<title>View Todo Notes</title>

<style type="text/css">
.text-design-sort {
	font-family: galindo;
	text-shadow: 1px 1px #ff0000;
}

.table .thead-test th {
	font-family: galindo;
	font-size: 18px;
	color: #401500;
	background-color: #FFDDCC;
	border-color: #792700;
}

.text-formatting {
	font-family: galindo;
	text-shadow: 0px 0px black;
	font-size: 18px;
}

.text-style {
	font-family: galindo;
	font-size: 18px;
}
</style>
</head>
<body>
	<%@include file="all_Component/navbar.jsp"%>
	<%
		if (user == null) {
			session.setAttribute("ErrorMssg", "Please login...");
			response.sendRedirect("login.jsp");
		}
	%>

	<%
		String successMssg = (String) session.getAttribute("successMessage");
		String errorMssg = (String) session.getAttribute("errorMessage");

		if (successMssg != null) {
	%>
	<div class="alert alert-success text-style" role="alert">
		<%=successMssg%>
	</div>
	<%
		session.removeAttribute("successMessage");
		}

		if (errorMssg != null) {
	%>
	<div class="alert alert-danger text-style" role="alert">
		<%=errorMssg%>
	</div>
	<%
		session.removeAttribute("errorMessage");
		}
	%>
	<div class="container mt-5">
		<h1 class="text-center text-design-sort">
			<i class='fa fa-eye'></i> <u>View Todo Notes </u>
		</h1>

		<table class="table table-bordered table-hover mt-5">
			<thead class="thead-test">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Title</th>
					<th scope="col">Status</th>
					<th scope="col">Username</th>
					<th scope="col">Description</th>
					<th scope="col">Actions</th>

				</tr>
			</thead>

			<%
				if (user != null) {
					TodoDAO todoDAO = new TodoDAO();
					List<Todo> lists = todoDAO.getAllTodos(user.getId());

					for (Todo items : lists) {
			%>
			<tbody>
				<tr class="text-formatting">
					<td><%=items.getId() %></td>
					<td><%=items.getTitle()%></td>
					<td><%=items.isStatus()%></td>
					<td><%=items.getUsername()%></td>
					<td><%=items.getDescription()%></td>

					<td><a href="editTodo.jsp?todoId=<%=items.getId()%>"> Edit
					</a>&nbsp;&nbsp;&nbsp; <a href="delete?todoId=<%=items.getId()%>">
							Delete </a></td>
				</tr>

			</tbody>
			<%
				}
				}
			%>

		</table>

	</div>

	<%@include file="all_Component/footer.jsp"%>

</body>
</html>