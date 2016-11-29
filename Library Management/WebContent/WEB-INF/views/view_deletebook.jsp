<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete User</title>
</head>
<body>
<center>
<jsp:include page="/public/adminheader.jsp"></jsp:include><br>
	Delete this Book!!!!
	<form method="post">
		<table>
			<tr><td>Book Name :</td><td>${deletebook.book_name }</td></tr>
			<tr><td>Edition :</td><td>${deletebook.edition }</td></tr>
			<tr><td>Author Name :</td><td>${deletebook.author_name }</td></tr>
			<tr><td>Category :</td><td>${deletebook.category }</td></tr>
			<tr><td>Available Copy :</td><td>${deletebook.available_copy }</td></tr>
			<tr><td>Total Copy :</td><td>${deletebook.total_copy }</td></tr>
			<tr><td></td><td></td><td><input type="submit"  value="Confirm Delete"/></td></tr>
		</table>
		</form>
	</center>

</body>
</html>