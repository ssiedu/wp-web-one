package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TaxCalculator")
public class TaxCalculator extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//reads the request
		int income=Integer.parseInt(request.getParameter("income"));
		int age=Integer.parseInt(request.getParameter("age"));
		String assets[]=request.getParameterValues("assets");
		String nri=request.getParameter("nri");
		
		int nriCharges=0;
		
		if(nri!=null) {
			nriCharges=5000;
		}
		
		
		
		
		//process the request
		int tax=0;
		if(income>=500000) {
			tax=income*20/100;
		}else {
			tax=income*10/100;
		}
		
		int rebate=0;
		if(age>=60) {
			rebate=tax*10/100;
		}
		
		int nettax=tax-rebate;
		
		//provide the response
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Thanks For Visiting Us.<h1>");
		out.println("<table border=2>");
		out.println("<tr>");
		out.println("<td>Tax</td><td>"+tax+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Rebate</td><td>"+rebate+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>NetTax</td><td>"+nettax+"</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>NRICharges</td><td>"+nriCharges+"</td>");
		out.println("</tr>");
		out.println("</table>");
		if(assets!=null) {
		out.println("Assets Declared By You : ");
		for(String asset:assets) {
			out.println(asset);
		}
		}
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		out.close();
		
	}

}
