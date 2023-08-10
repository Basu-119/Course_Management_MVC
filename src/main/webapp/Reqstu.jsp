<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.container {

        max-width: 800px;

        margin: 0 auto;

        padding: 20px;

        background-color: white;

        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);

    }</style>
</head>
<body>
<div class="container">
<%
session=request.getSession();
String req_stu_name=(String)session.getAttribute("req_stu_name");

%>
<h1>
<%
out.print(req_stu_name);

%>
</h1>
<h6>
Your Request is Pending .
Wait for confirmation .
</h6>
</div>
</body>
</html>