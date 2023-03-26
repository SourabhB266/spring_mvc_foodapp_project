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
	<form:form action="linkmanager" modelAttribute="branch">   
	
	Id <form:input path="id" readonly="true" />
		<br>
		<br>
	Name <form:input path="name" readonly="true" />
		<br>
		<br>
	Address <form:input path="address" readonly="true" />
		<br>
		<br>  
	Phone <form:input path="phoneNumber" readonly="true" />
		<br>
		<br>
	Email <form:input path="email" readonly="true" />
		<br>
		<br>
	
	Manager Id <form:input path="user.id" />
		<br>
		<br>
	
		<input type="submit">

	</form:form>
	
	<br> <br>
	
</body>
</html>