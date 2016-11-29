<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search List</title>
</head>
<body>
	<center>
	<jsp:include page="/public/guestheader.jsp"></jsp:include><br>
		<table border="1">
		<tr>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Category</th>
			<th>Author Name</th>
			<th>Edition</th>
			<th>Available Copy</th>
			<th>Total Copy</th>
		</tr>
		<c:forEach var="bl" items="${blist}">
		<tr>
			<td>${bl.book_id}</td>
			<td>${bl.book_name}</td>
			<td>${bl.category}</td>
			<td>${bl.author_name}</td>
			<td>${bl.edition}</td>
			<td>${bl.available_copy}</td>
			<td>${bl.total_copy}</td>
		</tr>
		</c:forEach>
	</table>
	</center>
</body>
</html>