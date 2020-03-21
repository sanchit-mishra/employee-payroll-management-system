<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstlc" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
  width: 80%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
hr {width: 20px;border: 2px solid grey;}
</style>
</head>
<body>
	<jsp:include page="registerHeader.jsp"></jsp:include>

	<center>
		<h2>Employee List</h2>
		<table>
			<thead>
				<th>id</th>
				<th>Username</th>
				<th>Password</th>
				<th>Action</th>
			</thead>
			<jstlc:forEach var="remp" items="${register_list}">
				<tr>
					<td>${remp.id}</td>
					<td>${remp.username}</td>
					<td>${remp.password}</td>
					
					<td>
					
					  
					<a href="del?id=${remp.id}" onclick="return confirm('Are you sure you want to delete the login info?');">Delete</a>
					</td>
				</tr>
			</jstlc:forEach>
		</table>
	</center>
</body>
</html>