package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */

@WebServlet(
		urlPatterns = { "/Test" }, 
		initParams = { 
				@WebInitParam(name = "city", value = "indore"), 
				@WebInitParam(name = "state", value = "mp")
		})
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		
		Map<String,String[]> map=request.getParameterMap();
		
		Set<String> keys=map.keySet();
		
		Collection<String[]> values=map.values();
		
		
		
		
	/*	Enumeration<String> en=request.getParameterNames();
		while(en.hasMoreElements()) {
			String name=en.nextElement();
			String value=request.getParameter(name);
			out.println(name+","+value);
		}
		*/
	
	
	}

}
