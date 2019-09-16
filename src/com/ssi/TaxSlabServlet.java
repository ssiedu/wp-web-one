package com.ssi;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TaxSlabServlet
 */
@WebServlet("/TaxSlabServlet")
public class TaxSlabServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/vnd.ms-excel");
		
		//read
		//process (we need to read a file)
		FileInputStream fis=new FileInputStream("g:\\data\\TaxSlabs.xlsx");
		byte b[]=new byte[fis.available()];
		fis.read(b);
		fis.close();
		//response
		ServletOutputStream out=response.getOutputStream();
		out.write(b);
		out.close();
	}

}
