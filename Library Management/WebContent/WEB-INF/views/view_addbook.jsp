<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/public/header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member List</title>
</head>
<body>
<center>
<jsp:include page="/public/adminheader.jsp"></jsp:include>
		<form method="post">
		<table>
			<tr><td>Book Name :</td><td><input type="text" name="book_name" required/></td></tr>
			<tr><td>Edition :</td><td><input type="text" name="edition" required/></td></tr>
			<tr><td>Author Name :</td><td><input type="text" name="author_name" required/></td></tr>
			<tr><td>Category:</td><td><input type="text" name="category"required/></td></tr>
			<tr><td>Available Copy :</td><td><input type="text" name="available_copy"required/></td></tr>
			<tr><td>Total Copy :</td><td><input type="text" name="total_copy"required/></td></tr>
			<tr><td></td><td></td><td><input type="submit"  value="Add Book"/></td></tr>
		</table>
		</form>
		
	</center>

</body>
</html>