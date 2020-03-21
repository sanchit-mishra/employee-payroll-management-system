<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<center>
		<fieldset>
			<legend>Edit Employee Form</legend>
			<form
				action="${pageContext.request.contextPath}/edit_employee_action"
				method="POST" modelAttribute="employee">
				
				<input type="hidden" name="id" value ="${employee.id}"><br/><br/>
				
			Name:	<input type="text" name="name" placeholder="Employee Name"
					value="${employee.name}" /><br /><br />
					
			Age:	 <input type="number" name="age" placeholder="Employee Age"
					value="${employee.age}" /><br /> <br /> 
					
			Designation:		<input type="text"
					name="designation" placeholder="Employee Designation"
					value="${employee.designation}" /><br />
				<br /> 
				
			Salary:	<input type="number" name="salary"
					placeholder="Employee Salary" value="${employee.salary}"><br />
				<br /> 
				
				<input type="submit" name="add" value="Save"> <input
					type="reset" value="Clear">
			</form>
		</fieldset>
	</center>
</body>
</html>