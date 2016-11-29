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
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Phone</th>
			<th>Email</th>
			<th>Address</th>
			<th>Date of Birth</th>
			<th colspan="2">OPTION</th>
		</tr>
		<c:forEach var="mem" items="${mlist}">
		<tr>
			<td>${mem.member_name}</td>
			<td>${mem.phone}</td>
			<td>${mem.email}</td>
			<td>${mem.address}</td>
			<td>${mem.dob}</td>
			<td><a href="/librarymanagement/editmember?id=${mem.user_id}">Edit</a></td>
			<td><a href="/librarymanagement/deletemember?id=${mem.user_id}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
	</center>
</body>
<script type="text/javascript">
	$("#sb").on("keyup", function() {
    var value = $(this).val().toUpperCase();
      
		console.log(value);

    $("table tr").each(function(index) {
        if (index !== 0) {

            $row = $(this);

            var id = $row.find("td:first").text().toUpperCase();
            console.log(id);

            if (id.indexOf(value) !== 0) {
                $row.hide();
            }
            else {
                $row.show();
            }
        }
    });
});
</script>
</html>