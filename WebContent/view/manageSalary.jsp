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
	<jsp:include page="salaryHeader.jsp"></jsp:include>

	<center>
		<h2>Salary Management</h2>
		<table>
			<thead>
				<th>Id</th>
				<th>Month</th>
				<th>Leave</th>
			<!--	<th>Salary_Deduction</th> -->
			<!--	<td>${salary.salaryDeduction}</td> -->
				
			</thead>
			<jstlc:forEach var="salary" items="${salary_list}">
				<tr>
					<td>${salary.id}</td>
					<td>${salary.month}</td>
					<td>${salary.leave_}</td>
				
					<td>
					<!--  <a href="edit?id=${employee.id}">Edit</a> |
					  <a href="manage?id=${employee.id}">Manage</a> |
					<a href="delete?id=${employee.id}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a>-->
					</td>
				</tr>
			</jstlc:forEach>
		</table>
	</center>
</body>
</html>