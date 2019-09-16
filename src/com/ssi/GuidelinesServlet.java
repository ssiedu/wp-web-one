package com.ssi;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/GuidelinesServlet")

public class GuidelinesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletConfig config=getServletConfig();
		String file=config.getInitParameter("guideline-file");
		/*String author=config.getInitParameter("author");
		response.getWriter().print(file+","+author);*/
		
		
		
		response.setContentType("application/msword");

		// read
		// process (we need to read a file)
		FileInputStream fis = new FileInputStream(file);
		byte b[] = new byte[fis.available()];
		fis.read(b);
		fis.close();
		// response
		ServletOutputStream out = response.getOutputStream();
		out.write(b);
		out.close();
		
	}

}
