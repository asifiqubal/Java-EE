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
		
			<tr><td>Name :</td><td><input type="text" name="mname" value="${mlist.member_name }" /></td></tr>
			<tr><td>Phone :</td><td><input type="text" name="phone" value="${mlist.phone }" /></td></tr>
			<tr><td>Email :</td><td><input type="text" name="email" value="${mlist.email }"/></td></tr>
			<tr><td>Date of Birth:</td><td><input type="text" name="dob" value="${mlist.dob }" /></td></tr>
			<tr><td>Address :</td><td><input type="textarea" name="address" value="${mlist.address }"/></td></tr>
			<tr><td></td><td></td><td><input type="submit"  value="Edit"/></td></tr>
			
		</table>
		</form>
		
	</center>

</body>
</html>