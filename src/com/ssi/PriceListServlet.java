package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PriceListServlet
 */
@WebServlet("/PriceListServlet")
public class PriceListServlet extends HttpServlet {

	private Connection con;
	private PreparedStatement ps;
	
	public void destroy() {
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void init() {
		ServletContext context = getServletContext();
		String drivername = context.getInitParameter("driver-name");
		String connectionURL = context.getInitParameter("connection-url");
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		try {
		Class.forName(drivername);
		con = DriverManager.getConnection(connectionURL, username, password);
		String sql = "select pname,price from prodinfo";
		ps = con.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//reading userid from session
		//step-1 (fetch the session object created for this user)
		HttpSession session=request.getSession();
		
		//step-2 (read the value from session object)
		String userid=(String) session.getAttribute("userid");
		
		if(userid==null) {
			response.sendRedirect("login.jsp");
		}
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Welcome "+userid+"</h3>");
		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				out.println(rs.getString(1) + "," + rs.getString(2)+"<br>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</body></html>");
	}

}
