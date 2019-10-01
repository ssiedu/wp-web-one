package com.ssi;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("SESSION CREATED ");
		//HttpSession session=hse.getSession();
		//ServletContext context=hse.getSession().getServletContext();
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		// TODO Auto-generated method stub
		System.out.println("SESSION DESTROYED");
	}

}
