package com.ssi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctype="";
		String choice=request.getParameter("info");
		
		switch(choice) {
			case "slab":
				ctype="application/vnd.ms-excel";
			break;
			case "guide":
				ctype="application/msword";
			break;
		}
		
		response.setContentType(ctype);
		
		
		
		
	}

}
