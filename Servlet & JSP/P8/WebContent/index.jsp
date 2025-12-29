<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/mylib" prefix="t" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page</title>
</head>
<body>
Hello
<t:mytag></t:mytag>
<t:printTable number="50" color="red"></t:printTable>
<t:printTable number="90" color="blue"></t:printTable>
</body>
</html>