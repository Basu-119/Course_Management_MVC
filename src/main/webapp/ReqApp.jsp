<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session=request.getSession();
String req_pro_name=(String)session.getAttribute("req_pro_name");

%>
<h1>
<%
out.print(req_pro_name);

%>
</h1>
<h6>
Your Request is Pending .
Wait for confirmation .
</h6>
</body>
</html>