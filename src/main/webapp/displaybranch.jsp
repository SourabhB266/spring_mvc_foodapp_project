<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2px" style="width: 50%">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Manager Name</th>
				<th>Delete</th>
				<th>Edit</th>
				<th>Add Manager</th>

			</tr>
		</thead>

		<tbody style="text-align: center;">
			<c:forEach var="branch" items="${list}">
				<tr>
					<td>${branch.id}</td>
					<td>${branch.name}</td>
					<td>${branch.address}</td>
					<td>${branch.phoneNumber}</td>
					<td>${branch.email}</td>
					<td>${branch.user.name}</td>
					<td><a href="delete?id=${branch.id}">delete</a></td>
					<td><a href="edit?id=${branch.id}">edit</a></td>
					<td><a href="addmanager?id=${branch.id}">Add Manager</a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<br>
	<br>

	<a href="branch">
		<button>Add Branch</button>
	</a>

	<a href="save.jsp" style="margin-left: 100px">
		<button>Create Manager</button>
	</a>

	<a href="showmanagerslist" style="margin-left: 100px">
		<button>Show Manager</button>
	</a>
</body>
</html>