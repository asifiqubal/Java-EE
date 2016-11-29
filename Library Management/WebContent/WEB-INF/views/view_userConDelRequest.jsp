<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="/public/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
</head>
<body>
<center>
<jsp:include page="/public/userheader.jsp"></jsp:include>
		<form method="post">
		<p>Are you sure you want to cancel the following request?</p>
		
		<table>
			<tr><td>Book Name :</td><td><label>${list.book_name }</label></td></tr>
			<tr><td>Edition :</td><td><label>${list.edition }</label></td></tr>
			<tr><td>Author :</td><td><label>${list.author_name }</label></td></tr>
			<tr><td>Category :</td><td><label>${list.category }</label></td></tr>
			<tr><td><input type='hidden' name='borrow_id' value="${list.borrow_id }" /></td></tr>
			<tr><td><input type='hidden' name='book_id' value="${list.book_id }" /></td></tr>
			<tr><td><input type='hidden' name='available_copy' value="${list.available_copy }" /></td></tr>
			<tr><td></td><td><input type="submit"  value="Confirm"/></td></tr>
		</table>
		</form>
	</center>
</body>
</html>