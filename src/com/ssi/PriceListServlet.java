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
		PrintWriter out = response.getWriter();

		try {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				out.println(rs.getString(1) + "," + rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
