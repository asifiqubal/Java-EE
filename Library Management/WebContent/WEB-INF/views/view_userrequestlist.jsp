<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Request</title>
<script type="text/javascript" src="/librarymanagement/public/scripts/jquery.js"></script>

</head>
<body>
<center>
<jsp:include page="/public/userheader.jsp"></jsp:include>
	<table border="1">
		<tr>
			<th>Book Name</th>
			<th>Edition</th>
			<th>Author Name</th>
			<th>Request Date</th>
		</tr>
		<c:forEach var="rl" items="${requestlist}">
		<tr>
			<td>${rl.book_name}</td>
			<td>${rl.edition}</td>
			<td>${rl.author_name}</td>
			<td>${rl.request_date}</td>
		</tr>
		</c:forEach>
	</table>
</center>
</body>
</html>