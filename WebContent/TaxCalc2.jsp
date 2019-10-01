<%
	int income=Integer.parseInt(request.getParameter("income"));
%>

<jsp:useBean id="bean" class="com.ssi.TaxBean"/>
<jsp:setProperty name="bean" property="income" value="<%=income%>"/>


<html>
<body>
	<h3>Tax-Details-Using-Bean</h3>
	<hr>
		<pre>
		Income	<jsp:getProperty property="income" name="bean"/>
		Tax	<jsp:getProperty property="tax" name="bean"/>
		</pre>
	<hr>
</body>
</html>