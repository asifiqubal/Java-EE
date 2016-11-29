<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin BookList</title>
</head>
<body>
<center>
<jsp:include page="/public/adminheader.jsp"></jsp:include><br>
	<h3>Borrow History</h3>
	<br/>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>Book Name</th>
			<th>Edition</th>
			<th>Borrow Date</th>
			<th>Expected Return Date</th>
			<th>Return Date</th>
			<th>Fine</th>
			<th>Option</th>
		</tr>
		<c:forEach var="borrow" items="${borrowHistory}">
		<tr>
			<td>${borrow.user_id}</td>
			<td>${borrow.book_name}</td>
			<td>${borrow.edition}</td>
			<td>${borrow.borrow_date}</td>
			<td>${borrow.expected_return_date}</td>
			<td>${borrow.return_date}</td>
			<td>${borrow.fine}</td>
			<td><a href='/librarymanagement/returnbook?borrow_id=${borrow.borrow_id}'>Return</a></td>
		</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>