package com.p3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S2
 */
@WebServlet("/s2")
public class S2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1=request.getParameter("n1");
		String n2=request.getParameter("n2");
		int a=Integer.parseInt(n1);
		int b=Integer.parseInt(n2);
		int p=a*b;
		int sum=(int) request.getAttribute("sum");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("sum is: "+sum);
		out.println("product is: "+p);
	}
}
