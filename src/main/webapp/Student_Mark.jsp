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
String selstu=(String) session.getAttribute("selstu");
String grade= (String)session.getAttribute("grade");
int mark=(int) session.getAttribute("mark");
int fmark=(int) session.getAttribute("fmark");
out.print(selstu);
out.print(fmark);
out.print(mark);
out.print(grade);

%>
</body>
</html>