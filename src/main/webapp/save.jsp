<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="save" modelAttribute="user">   
	
	Id <form:input path="id" />
		<br>
		<br>
	Name <form:input path="name" />
		<br>
		<br>
	Email <form:input path="email" />
		<br>
		<br>  
	Password <form:input path="password" />
		<br>
		<br>
	Role <input type="radio" name="role" value="admin"> Admin
		<input type="radio" name="role" value="staff"> Staff
		<input type="radio" name="role" value="branch manager"> Staff Manager
		<br>
		<br>

		<input type="submit">

	</form:form>

</body>
</html>