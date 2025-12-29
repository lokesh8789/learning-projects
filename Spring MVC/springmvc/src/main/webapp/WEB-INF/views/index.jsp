<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	In Home Page!!
	<%
	String name = (String) request.getAttribute("name");
	Integer id = (Integer) request.getAttribute("id");
	List<String> al = (List<String>) request.getAttribute("list");
%>
	<%=name%>
	<%=id%>
	<%
		for (String s : al) {
			out.println(s);
		}
	%>
	<%
		for (String s : al) {
	%>
	<h1><%=s%></h1>
	<%
		}
	%>
</body>
</html>