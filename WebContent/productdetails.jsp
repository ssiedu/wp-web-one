<jsp:useBean scope="session" id="product" class="com.ssi.Product"/>

<html>
<body>
	<h3>Product-Details</h3>
	<hr>
	<pre>
		Code	<jsp:getProperty name="product" property="code"/>
		Name	<jsp:getProperty name="product" property="name"/>
		Desc	<jsp:getProperty name="product" property="desc"/>
		Catg	<jsp:getProperty name="product" property="category"/>
		Price	<jsp:getProperty name="product" property="price"/>
	</pre>
	<hr>
	<a href="search.jsp">Search-More</a><br>
</body>
</html>
