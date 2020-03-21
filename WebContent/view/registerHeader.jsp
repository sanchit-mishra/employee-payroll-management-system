<%

	String session_username = (String)session.getAttribute("username");
	
%>

<div>
	<div style="float: left">
		<% if(session_username != null) { %>
			<a href="${pageContext.request.contextPath}/register_employee">Add</a> | 
			<a href="${pageContext.request.contextPath}/register">List</a> |
			<a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
		<% } %>
	</div>

	  <div style="float: right">
		<% if(session_username == null) { %>
			  <a href="${pageContext.request.contextPath}/login">Admin Login</a>
		<% } %>
		<% if(session_username == null) { %>
			  <a href="${pageContext.request.contextPath}/emplogin">Employee Login</a>
		<% } %>

		<% if(session_username != null) { %>
			Welcome <%= session.getAttribute("username") %> | 
			<a href="${pageContext.request.contextPath}/logout">Logout</a>
		<% } %>

	</div>
</div>


<br />
<br />

<center>
	<header style="background-color: lightblue; color: white; height: 50px;">
		<h1>Employee Payroll System</h1>
	</header>
</center>
