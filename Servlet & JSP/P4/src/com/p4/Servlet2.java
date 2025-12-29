package com.p4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//getting cookies
		Cookie[] cookies=request.getCookies();
		boolean f=false;
		String name="";
		if(cookies==null)
		{
			out.println("<h1> you are new user</h1>");
			return;
		}
		else
		{
			for(Cookie c:cookies)
			{
				String temp=c.getName();
				if(temp.equals("user_name"))
				{
					f=true;
					name=c.getValue();
				}
			}
		}
		if(f)
		{
			out.println("<h1> Hello,"+name+"welcome back</h1>");
		}
		else
		{
			out.println("<h1> you are new user</h1>");
		}

	}
}
