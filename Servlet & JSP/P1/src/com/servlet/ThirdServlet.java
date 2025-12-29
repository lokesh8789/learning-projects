package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class ThirdServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		System.out.println("this is method....");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>this is me</h1>");
	}
}
