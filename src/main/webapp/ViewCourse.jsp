<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>
body {
font-family: Arial, sans-serif;
line-height: 1.6;
background-color: #f8f8f8;
margin: 0;
padding: 0;
display: flex;
justify-content: center;
align-items: center;
height: 100vh;
}

table {
width: 60%;
border-collapse: collapse;
margin-bottom: 20px;
border: 1px solid #ccc;
box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
background-color: #fff;
}

th, td {
padding: 12px 15px;
text-align: left;
border-bottom: 1px solid #ccc;
}

th {
background-color: #f2f2f2;
}

tr {
animation: fadeIn 0.5s ease;
transition: background-color 0.3s ease;
}

tr:hover {
background-color: #f5f5f5;
}

caption {
text-align: left;
font-size: 1.2em;
margin-bottom: 10px;
}

@keyframes fadeIn {
from {
opacity: 0;
}
to {
opacity: 1;
}
}
</style>
<title>COURSE</title>
</head>
<body>
	<%
	session = request.getSession();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/course_mvc";
		String user = "root";
		String pwd = "root";
		Connection con = DriverManager.getConnection(url, user, pwd);
		ResultSetMetaData metadata;
		String sql = "select * from courses";
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(sql);
		metadata = res.getMetaData();
		int j = metadata.getColumnCount();
	%>
	<table class="table-hover table-bordered dark table-dark" >
		<tr>
			<%
			for (int i = 1; i <= j; i++) {
				out.print("<th style=\"text-align: left;\">" + metadata.getColumnName(i) + "</th>");
			}
			%>
		</tr>
		<%
		while (res.next() == true) {
		%>
		<tr>
			<%
			for (int i = 1; i <= j; i++) {
				out.print("<td style=\"text-align: left;\">" + res.getString(i) + "</td>");
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>
</body>
</html>