<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="java.util.Random,java.io.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- 	declaration tag -->
	<%!int a = 5;
	int b = 6;

	public int sum() {
		return a + b;
	}
	%>
<!-- 	scriptlet tag -->
	<%
		out.println(a);
		out.println(b);
		out.println("<br>");
		out.println("sum is: "+sum());
	%>
	<!--expression tag -->
	<h1>Sum is: <%= sum() %></h1>
	<h1>Random Number:
	<%
		Random r=new Random();
		int n=r.nextInt(20);
		//out.println(n);
		
	%>
	<%= n%>
	</h1>
	<!-- include directive -->
	<%@include file="header.jsp" %>
	
	<!-- taglib directive -->
	<c:set var="name" value="Wow lokesh"></c:set>
	<c:out value="${name}"></c:out>
	<c:if test="${3>2}">
		<h2> inside if block</h2>
	</c:if>
	<%!
		int m=10;
		int p=5;
	%>
	<%
		int d=m/p;
	%>
	div is: <%= d %>
</body>
</html>