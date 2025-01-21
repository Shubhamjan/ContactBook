<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Component/allCss.jsp"%>
<%@ page import="com.demo.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Book</title>
<style type="text/css">
.back-img {
	background: url("img/photo.jpeg");
	width: 100%;
	height: 85vh;
	background-repeat: no-repeat;
	background-size: cover;
}


.h {
	font-weight: bolder;
}
</style>
</head>
<body>
	<%@ include file="Component/navbar.jsp"%>

	
	<div class="container-fluid back-img text-center text-success ">
		<h1 class="h">Welcome To Contact Manager</h1>
		
	</div>
<%@ include file="Component/footer.jsp"%>
</body>
</html>