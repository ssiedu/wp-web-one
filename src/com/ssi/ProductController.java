package com.ssi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProductController")

public class ProductController extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//read-the-request
			int code=Integer.parseInt(request.getParameter("code"));
			//process-it-using-service
			ProductService service=new ProductService();
			Product product=service.getProductDetails(code);
			//store-the-model-to-scope-object
			//request.setAttribute("product", product);
			request.getSession().setAttribute("product", product);
			//forward-the-request-to-view
			RequestDispatcher dispatcher=request.getRequestDispatcher("productdetails.jsp");
			dispatcher.forward(request, response);
		}

}
