package com.ssi;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbConListener implements ServletContextListener {

	Connection con;
	
	
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("CONTEXT DESTROYED");
    	try {
    		con.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("CONTEXT CREATED");
    	ServletContext context = sce.getServletContext();
		String drivername = context.getInitParameter("driver-name");
		String connectionURL = context.getInitParameter("connection-url");
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		try {
		Class.forName(drivername);
		con = DriverManager.getConnection(connectionURL, username, password);
		context.setAttribute("connection", con);
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
}
