<%
	long inactiveInterval=session.getMaxInactiveInterval();

	long creationTime=session.getCreationTime();
	java.util.Date dt=new java.util.Date(creationTime);


	//step-1 (fetch all the cookies coming with request)
		Cookie cookies[]=request.getCookies();		

	
	//step-2 (search for the desired cookies)
		String v1="",v2="";
		if(cookies!=null)
		for(Cookie cookie:cookies){
			String name=cookie.getName();
			if(name.equals("userid")){
				v1=cookie.getValue();
			}else if(name.equals("password")){
				v2=cookie.getValue();
			}
		}

%>
<%=inactiveInterval %>
<%=creationTime%>
<%=dt%>
<html>
<body>
	<form action="VerifyUser">
		<pre>
		Userid		<input type="text" name="userid" value="<%=v1%>"/>
		Password	<input type="password" name="password" value="<%=v2%>"/>
		SavePwd		<input type="checkbox" name="save" checked="checked" />
					<input type="submit" value="Login"/>
		
		</pre>
	</form>
</body>
</html>