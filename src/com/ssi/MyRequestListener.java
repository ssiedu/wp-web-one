package com.ssi;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyRequestListener
 *
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent sre)  {
    	System.out.println("REQUEST DESTROYED");
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
    	System.out.println("REQUEST CREATED");
    }
	
}
