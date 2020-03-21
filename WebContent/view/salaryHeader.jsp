<%

	String session_username = (String)session.getAttribute("username");
	
%>

<div>
	<div style="float: left">
		<% if(session_username != null) { %>
			<a href="${pageContext.request.contextPath}/manage_salary">Add</a>  
		
		<% } %>
	</div>

	  <div style="float: right">
		<% if(session_username == null) { %>
			  <a href="${pageContext.request.contextPath}/login">Login</a>
		<% } %>
		<% if(session_username == null) { %>
			  <a href="${pageContext.request.contextPath}/emplogin">Login</a>
		<% } %>

		<% if(session_username != null) { %>
			Welcome <%= session.getAttribute("username") %> | 
			<a href="${pageContext.request.contextPath}/logout">Logout</a>
		<% } %>

	</div>
</div>
