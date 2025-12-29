package com.p3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S1
 */
@WebServlet("/s1")
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1=request.getParameter("n1");
		String n2=request.getParameter("n2");
		int a=Integer.parseInt(n1);
		int b=Integer.parseInt(n2);
		int sum=a+b;
		request.setAttribute("sum", sum);
		RequestDispatcher rd=request.getRequestDispatcher("s2");
		rd.forward(request, response);
	}
}
