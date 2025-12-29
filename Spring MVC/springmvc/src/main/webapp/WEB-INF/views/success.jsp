<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${Header }
${Desc }
<%-- name-${name }
email-${email }
pass-${password } --%>
name-${user.userName }
email-${user.email }
pass-${user.password }
<hr>
${msg }
</body>
</html>