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
	
	<form method="post">
		<table>
			<tr><td>Book Name :</td><td>${blist.book_name }</td></tr>
			<tr><td>User ID :</td><td>${blist.user_id }</td></tr>
			<tr><td>Expect Return Date :</td><td>${blist.expected_return_date }</td></tr>
			<tr><td>Return Date :</td><td>${rdate }</td></tr>
			<tr><td>Fine :</td><td>${fine }</td></tr>
			<input type="hidden" name="fine" value="${fine }"/>
			<input type="hidden" name="rdate" value="${rdate }"/>
			<tr><td></td><td></td><td><input type="submit"  value="Confirm Return"/></td></tr>
		</table>
		</form>
	</center>

</body>
</html>