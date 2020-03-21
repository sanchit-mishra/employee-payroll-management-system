<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
a{text-decoration: none;color: white;}
.btn{color: red;width: 35%;}
a:visited{color: white;}
a:hover{text-decoration: none;}


</style>
<%

	String session_username = (String)session.getAttribute("username");
	
%>


 <center>
		<% if(session_username == null) { %>
			<button class="btn btn-info">  <a href="${pageContext.request.contextPath}/login">Admin Login</a></button>
		<% } %>
		
		
		<% if(session_username == null) { %>
			 <button class="btn btn-info"> <a href="${pageContext.request.contextPath}/emplogin">Employee Login</a></button>
		<% } %>
	</center>	
		
			<div style="float: right;"><% if(session_username != null) { %>
			Welcome <%= session.getAttribute("username") %> | 
			<button class="btn btn-info"> <a href="${pageContext.request.contextPath}/logout2">Logout</a></button>
		<% } %></div>

	
