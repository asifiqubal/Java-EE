<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrow Request</title>
</head>
<body>
<center>
<jsp:include page="/public/adminheader.jsp"></jsp:include><br>
	<h3>Borrow Request</h3>
	<br/>
	<table border="1">
		<tr>
			<th>User ID</th>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Edition</th>
			<th>Request Date</th>
			<th colspan="2">Option</th>
		</tr>
		<c:forEach var="borrow1" items="${borrowRequest}">
		<tr>
			<td>${borrow1.user_id}</td>
			<td>${borrow1.book_id}</td>
			<td>${borrow1.book_name}</td>
			<td>${borrow1.edition}</td>
			<td>${borrow1.borrow_date}</td>
			<td><a href='/librarymanagement/adminConDelReq?id=${borrow1.borrow_id}&msg=delete&book_id=${borrow1.book_id}'>Delete Request</a></td>
			<td><a href='/librarymanagement/adminConDelReq?id=${borrow1.borrow_id}&msg=confirm'>Confirm Request</a></td>
		</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>