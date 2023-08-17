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
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="button.css">

<style>
body {
background-image:url('img2/ha1.jpg');
background-size: cover;
background-repeat: no-repeat;
background-attachment: fixed;
}
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

.container {
	max-width: 960px;
	margin: 0 auto;
	padding: 20px;
}

.table-container {
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-collapse: collapse;
	border: 1px solid #ccc;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	background-color: #fff;
}

th, td {
	padding: 12px 15px;
	text-align: left;
	border-bottom: 1px solid #ccc;
}

.martop {
	margin-top: 20px;
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

@
keyframes fadeIn {from { opacity:0;
	
}

to {
	opacity: 1;
}

}
.card {
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
	width: 525px;
	text-align: center;
}

.subscribe-form {
	margin-top: 20px;
}

.subscribe-email {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
}

.subscribe-button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
}

.tableh{
background-color: black;
color: black;
}
.subscribe-button:hover {
	background-color: #0056b3;
}
</style>
<title>COURSE</title>
</head>
<body>
	<div>
		<h1 style="margin-left: 60px;font-size:60px; color: white;">Approve Portal</h1>
	
		<%
		session = request.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/course_mvc";
			String user = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url, user, pwd);
			ResultSetMetaData metadata;
			String sql = "select * from prorequest";
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			metadata = res.getMetaData();
			int j = metadata.getColumnCount();
		%>
		<table class="table-hover table-dark">
			<tr class="tableh">
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

		<form class="custom-form subscribe-form mt-4" action="approvePro"
			role="form" method="post">
			<div class="row">
				<div class="col-lg-8 col-md-8 col-7">
					<input type="text" name="apppro" class="subscribe-email"
						style="width: 400px;" 	placeholder="YOUR NAME HERE" required>
				</div>
				<div class="col-lg-4 col-md-4 col-5">
					<button class="button-59 martop" style="background-color: white;" role="button">SUBMIT</button>
				</div>
			</div>
		</form>

	</div>

</body>
</html>