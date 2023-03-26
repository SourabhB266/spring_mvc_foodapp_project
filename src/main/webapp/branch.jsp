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

	<form:form action="savebranch" modelAttribute="branch">   
	
	Id <form:input path="id" />
		<br>
		<br>
	Name <form:input path="name" />
		<br>
		<br>
	Address <form:input path="address" />
		<br>
		<br>  
	Phone <form:input path="phoneNumber" />
		<br>
		<br>
	Email <form:input path="email" />
		<br>
		<br>

		<input type="submit">

	</form:form>


</body>
</html>