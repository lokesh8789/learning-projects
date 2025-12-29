package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<h1>Welcome</h1>");
		String name=req.getParameter("user_name");
		String password=req.getParameter("user_password");
		String email=req.getParameter("user_email");
		String gender=req.getParameter("user_gender");
		String course=req.getParameter("user_course");
		String cond=req.getParameter("condition");
		if(cond!=null)
		{
			if(cond.equals("checked"))
			{
				out.println("<h2>Name: "+name+"</h2>");
				out.println("<h2>Password: "+password+"</h2>");
				out.println("<h2>Email: "+email+"</h2>");
				out.println("<h2>Gender: "+gender+"</h2>");
				out.println("<h2>Course: "+course+"</h2>");
				
				RequestDispatcher rd=req.getRequestDispatcher("success");
				rd.forward(req, res);
			}
			else
			{
				out.println("<h2>Please Accept Term and Condition</h2>");
			}
		}
		else
		{
			out.println("<h2>Please Accept Term and Condition</h2>");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req,res);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
