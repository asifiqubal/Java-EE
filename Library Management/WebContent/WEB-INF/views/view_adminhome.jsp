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
<script type="text/javascript" src="/librarymanagement/public/scripts/jquery.js"></script>

</head>
<body>
<center>
<jsp:include page="/public/adminheader.jsp"></jsp:include>

	<form method="post">
	<input type="text" name="search" placeholder="Enter Book/Author Name" id="search" class="css"/><br>
	<input type="submit" value="Search Book"/>
	</form>
	</center>
</body>
<style type="text/css">
	.ui-autocomplete { 
    position: absolute; 
    cursor: default; 
    height: 100px; 
    overflow-y: scroll; 
    overflow-x: hidden;
    background-color: white;}
    .css{
    width: 35%;
    margin-bottom: 20px;
    height: 35px;
    border-radius: 5px;
    }
</style>
<script type="text/javascript">
$("#search").on("keyup", function() {
    $( "#search" ).autocomplete({   	
	source: function (request, response)
    {
        $.ajax(
        {

            url:"/librarymanagement/autocom" ,
           	dataType: "json",
            data: {'search':$('#search').val()},
            success: function (data)
            {
                response(data);
            }
        });
    },
            
});
});

</script>
</html>