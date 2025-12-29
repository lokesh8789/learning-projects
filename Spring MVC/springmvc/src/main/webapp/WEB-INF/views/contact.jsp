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
<form action="processform" method="post"> 
<p>Email<input type="email" name="email"></p>
<p>name<input type="text" name="userName"></p>
<p>Password<input type="password" name="password"></p>
<p>Submit<button type="submit">submit</button></p>
</form>
</body>
</html>