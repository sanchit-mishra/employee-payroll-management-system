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
<style>

</style>
</head>
<body>
	<jsp:include page="salaryHeader.jsp"></jsp:include>
<div class="container" style="width: 30%"><br>
	<center>
		<fieldset>
			<legend>Manage Salary</legend>
			<form action="${pageContext.request.contextPath}/manage_salary_action"
				method="POST" modelAttribute="salary">
				<input type="number" name="id" placeholder="Employee Id" class="form-control"/><br /> <br/>
					 <input type="text" name="month" placeholder="month" class="form-control"/><br /> <br/>
					<input type="number" name="leave_" placeholder="leave" class="form-control" /><br/><br/>
					
			<!-- 		<input type="number" name="salaryDeduction" placeholder="Salary Deduction" class="form-control"><br/><br/> -->
					<input type="submit" name="add" value="Add" class="btn btn-info btn-md">
					<input type="reset" value="Clear" class="btn btn-info btn-md">
			</form>
		</fieldset>
	</center>
	</div>
</body>
</html>