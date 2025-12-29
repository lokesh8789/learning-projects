package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;
public class FirstServlet implements Servlet{
	ServletConfig conf;
	//lifecycle method override
	public void init(ServletConfig conf)
	{
		this.conf=conf;
		System.out.println("creating object");
	}
	public void service(ServletRequest req,ServletResponse resp)throws ServletException,IOException
	{
		System.out.println("Servicing.....");
		//content type of response
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<h2>I am Here</h2>");
		out.println("<h2>Todays Date: "+new Date().toString()+"</h2>");
	}
	public void destroy()
	{
		System.out.println("goint to destroy");
	}
	// non lifecycle method override
	public ServletConfig getServletConfig()
	{
		return this.conf;
	}
	public String getServletInfo()
	{
		return "this servlet is created by lokesh";
	}
}
