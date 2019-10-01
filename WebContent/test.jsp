<%
	java.sql.Connection con=(java.sql.Connection)application.getAttribute("connection");
	out.println(con);
%>