<jsp:useBean id="bean" class="com.ssi.TaxBean"/>
<jsp:setProperty name="bean" property="income" param="income"/>

<html>
<body>
	<h3>Tax-Details-Using-Bean-Param</h3>
	<hr>
		<pre>
		Income	<jsp:getProperty property="income" name="bean"/>
		Tax	<jsp:getProperty property="tax" name="bean"/>
		</pre>
	<hr>
</body>
</html>