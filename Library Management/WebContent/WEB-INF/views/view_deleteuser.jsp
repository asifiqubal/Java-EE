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
	Delete this user!!!!
	<form method="post">
		<table>
		
			<tr><td>Name :</td><td>${mlist.member_name }</td></tr>
			<tr><td>Phone :</td><td>${mlist.phone }</td></tr>
			<tr><td>Email :</td><td>${mlist.email }</td></tr>
			<tr><td>Date of Birth:</td><td>${mlist.dob }</td></tr>
			<tr><td>Address :</td><td>${mlist.address }</td></tr>
			<tr><td></td><td></td><td><input type="submit"  value="Confirm Delete"/></td></tr>
			
		</table>
		</form>
	</center>

</body>
</html>