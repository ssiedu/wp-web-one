<%@page language="java" import="java.sql.Connection" %>


<%!
	public int x=10;

	int discount(int price){
		int disAmt=0;
		if(price>=10000){
			disAmt=price*20/100;
		}else{
			disAmt=price*10/100;
		}
		return disAmt;
	}
%>
<%
	Connection con=(java.sql.Connection)application.getAttribute("connection");
	String sql="select * from prodinfo";
	java.sql.PreparedStatement ps=con.prepareStatement(sql);
	java.sql.ResultSet rs=ps.executeQuery();
%>
<html>
<body>
	<h3>Products-List</h3>
	<hr>
		<table border="2">
			<tr>
				<th>Code</th><th>Name</th><th>Price</th><th>Disc</th>
			<tr>
<%
	while(rs.next()){
		String s1=rs.getString("code");
		String s2=rs.getString("pname");
		int s3=rs.getInt("price");
%>
		<tr>
			<td><% out.println(s1); %></td>
			<td><% out.println(s2); %></td>
			<td><%=s3%></td>
			<td><%=discount(s3)%></td>
		</tr>
<%		
	}
%>			
			
		
		</table>
	<hr>
</body>
</html>
