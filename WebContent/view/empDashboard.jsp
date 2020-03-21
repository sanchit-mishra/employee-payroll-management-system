<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstlc" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
hr {width: 30px;border: 2px solid black;}
.details{border:1px solid #17A2B8;border-radius: 10px;width: 20%;font-size: 19px;margin-left: 4%;}
</style>

</head>
<body>
<br>
<p style="font-size: 30px;text-align: center;background-color: #17A2B8;">WELCOME TO EMPLOYEE PAYROLL</p>
<hr size="3">
	<jsp:include page="header2.jsp"></jsp:include>

		<br><br><br>
		<center>
		<div style="display: flex;flex-wrap: wrap;">	
			<jstlc:forEach var="employee" items="${employee_list}">
				
					<!-- ${employee.id} -->
					<p class="details"><b>Name:</b> &nbsp;&nbsp;&nbsp;${employee.name}</p>
					<p class="details"><b>Age:</b>&nbsp;&nbsp;${employee.age}</p>
					<p class="details"><b>Designation:</b>&nbsp;&nbsp;${employee.designation}</p>
				 	<p class="details"><b>Salary:</b> &nbsp;&nbsp;&nbsp;${employee.salary}</p>
					
			</jstlc:forEach>
			</div>
			</center>
			<BR><br>
			<p style="text-align: center;background-color: #17A2B8;font-weight: 300;font-size: 24px">Salary Details</p>

			
			
			<!-- SALARY DETAILS -->
			<center>
			<div style="width: 10%">
			
			<div style="float: left;font-size: 19px;">
			<p style="border-bottom: 1px solid black;">MONTH</p>
			<jstlc:forEach var="monthList" items="${month_list}">					  
				    ${monthList}
				  <br>				
			</jstlc:forEach>
			</div>
			
			<div style="font-size: 19px;">
			<p style="border-bottom: 1px solid black;">SALARY</p>
			<jstlc:forEach var="salaryList" items="${salary_list}">			
				  ${salaryList}
				<br>
			</jstlc:forEach>
			</div>
		</div>
		
	</center>
</body>
</html>