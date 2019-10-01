
<jsp:include page="info.jsp"/>

<%
	int x;
	//public int y;
	String userid=(String)session.getAttribute("userid");
	if(userid==null){
		response.sendRedirect("login.jsp");
	}
	//session.setMaxInactiveInterval(1500);
%>
<html>
<body>
	<h3>Welcome <%=userid%></h3>
	<h3>My First Web Application</h3>
	<hr>
		<a href="inputs.jsp">Tax-Calc</a><br>
		<a href="allproducts.jsp">View-All-Products</a><br>
		<a href="PriceListServlet">View-Price-List</a><br>
		<a href="details.jsp">Know-Your-Tax-Liability</a><br>
		<a href="TaxSlabServlet">Read-Tax-Slabs</a><br>
		<a href="GuidelinesInfo">Read-Guidelines</a>
		
		<!-- <a href="InfoServlet?info=slab">Read-Tax-Slabs</a><br>
		<a href="InfoServlet?info=guide">Read-Guidelines</a> -->
	<hr>
</body>
</html>