<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
In help page!!
<%-- <%
String name=(String)request.getAttribute("name");
Integer r=(Integer)request.getAttribute("roll");
LocalDateTime time=(LocalDateTime)request.getAttribute("time");
%> --%>
<%-- <%=name%> --%>
<!-- use expression language to print -->
${name}
<%-- <%=r %> --%>
${roll }
<%-- <%=time.toString() %> --%>
${time.toString() }
<hr>
${l }
<hr>
<c:forEach var="item" items="${l }">
<h2>${item }</h2>
</c:forEach>
</body>
</html>