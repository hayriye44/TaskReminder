<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>İndex sayfası</h2>
<form action="logout" method="post">
<input type="submit" value="Logout">
<input type="hidden"
name="${_csrf.parameterName}"
value="${_csrf.token}">
</form>
</body>
</html>