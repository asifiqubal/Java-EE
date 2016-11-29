<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<center>
	<jsp:include page="/public/guestheader.jsp"></jsp:include>
	<form method="post">
	<table border="0">
		<tr>
			<td>User Name<td>
			<td><input type="text" name="user_name"/></td>
		</tr>
		<tr>
			<td>Password<td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" name="submit" value="Sign In"></td>
	</table>
	</form>
	<br/>
	<label>${errorMessage}</label>
</center>
</body>
</html>