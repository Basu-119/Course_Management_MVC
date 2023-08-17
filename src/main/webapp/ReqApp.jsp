<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

.container {
	text-align: center;
	margin-top: 100px;
}

h1 {
	color: #333;
	font-size: 36px;
}

h6 {
	color: #666;
	font-size: 18px;
}

.back-link {
	text-decoration: none;
	color: #007bff;
	font-weight: bold;
}
</style>

</head>

<body>

	<div class="container">

		<%
		session = request.getSession();
		String req_pro_name = (String) session.getAttribute("req_pro_name");
		%>

		<h1><%=req_pro_name%></h1>

		<h6>Your Request is Pending. Wait for confirmation.</h6>
		<a class="back-link" href="Home.html">Go to Main Page</a>

	</div>

</body>

</html>