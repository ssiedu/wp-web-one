<%
	int income=Integer.parseInt(request.getParameter("income"));
	com.ssi.TaxBean bean=new com.ssi.TaxBean();
	bean.setIncome(income);

%>
<html>
<body>
	<h3>Tax-Details</h3>
	<hr>
		<pre>
		Income	<%=bean.getIncome()%>
		Tax	<%=bean.getTax()%>
		</pre>
	<hr>
</body>
</html>