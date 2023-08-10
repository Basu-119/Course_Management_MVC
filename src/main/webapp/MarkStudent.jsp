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
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-size: cover;
	background-position: center;
}

.container {
	max-width: 400px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.9);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	text-align: center;
}

h1 {
	color: #3366cc;
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 8px;
	color: #555;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	background-color: #3366cc;
	color: #fff;
	font-weight: bold;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
	background-color: #005580;
}

.ka {
	opacity: 60%;
}

table {
	width: 100%;
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
</style>
<title>Insert title here</title>
</head>
<body>
	
	<div>
			<%
			session = request.getSession();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/course_mvc";
				String user = "root";
				String pwd = "root";
				Connection con = DriverManager.getConnection(url, user, pwd);
				ResultSetMetaData metadata;
				String sql = "select * from student where status!='marked'";
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql);
				metadata = res.getMetaData();
				int j = metadata.getColumnCount();
				session = request.getSession();
			%>
			<table class="table-hover table-dark">
				<tr>
					<%
					for (int i = 1; i <= j; i++) {
					%>
					<th style="text-align: left;"><%=metadata.getColumnName(i)%></th>
					<%
					}
					%>
				</tr>
				<%
				while (res.next()) {
				%>
				<tr>
					<%
					for (int i = 1; i <= j; i++) {
					%>
					<td style="text-align: left;"><%=res.getString(i)%></td>
					<%
					}
					%>
				</tr>
				<%
				}
				%>
			</table>
	
			<div class="container ">

				<form action="mark" method="post">
					<label>Name</label> <input type="text" name="selstu" required /> <label>Mark</label>
					<input type="text" name="getmark" required /> <input type="submit">
				</form>

			</div>

			<%
			} catch (Exception e) {
			e.printStackTrace();
			}
			%>
		</div>
	</div>
</body>
</html>