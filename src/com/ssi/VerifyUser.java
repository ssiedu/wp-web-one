package com.ssi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		if(userid.equals("aaa") && password.equals("bbb")) {
	
			//storing userid to session
			//step-1 (fetfch the session created for this user)
			HttpSession session=request.getSession();
			//step-2 (store the value in session object)
			session.setAttribute("userid", userid);
			
			String choice=request.getParameter("save");
			if(choice!=null) {
				//write the id/pwd using cookies to client machine
				//step-1 (create cookie object)
				Cookie c1=new Cookie("userid",userid);
				Cookie c2=new Cookie("password",password);
				//step-2 (set the the max age)
				c1.setMaxAge(60*60*24*7);
				c2.setMaxAge(60*60*24*7);
				//step-3 (add the cookie to response object)
				response.addCookie(c1);
				response.addCookie(c2);
			}
			
			
			
			
			
			response.sendRedirect("index.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
		
	}

}
