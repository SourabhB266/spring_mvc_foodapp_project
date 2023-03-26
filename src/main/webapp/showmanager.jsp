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
				<th>Email</th>
				<th>Password</th>
				<th>Role</th>
				<th>Edit</th>

			</tr>
		</thead>

		<tbody style="text-align: center;">
			<c:forEach var="user" items="${list}">
				<tr>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td><a href="editmanager?id=${user.id}">edit</a></td>

				</tr>
			</c:forEach>
		</tbody>

	</table>

	<br>
	<br>

	<a href="displaybranch.jsp">Back</a>

	<a href="signup.jsp"  style="margin-left: 100px" >Home</a>


</body>
</html>