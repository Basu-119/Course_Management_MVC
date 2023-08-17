<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">
.navbar {
	background-color: gray;
}
body {
background-image:url('img2/ha1.jpg');
background-size: cover;
background-repeat: no-repeat;
background-attachment: fixed;
}
.collapse {
	margin-left: 890px;
}

.custom-btn {
	width: 130px;
	height: 40px;
	color: #fff;
	border-radius: 5px;
	font-family: 'Lato', sans-serif;
	font-weight: 500;
	background: transparent;
	cursor: pointer;
	transition: all 0.3s ease;
	position: relative;
	display: inline-block;
	box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px
		0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
	outline: none;
}

/* 1 */
.btn-1 {
	background: transparent;
}

.btn-1:hover {
	background: black;
}

.btn-4 {
	background-color: transparent;
	text: black;
}

.txt {
	color: black;
}

.a {
	color: black;
}

.container2 {
	max-width: 400px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.9);
	border-radius: 10px;
	border-color: black;
	color: black;
	text-decoration: none;
	box-shadow: 0 0 40px rgba(0, 0, 0, 10%);
	text-align: center;
	margin: 20px;
	box-shadow: 0 0 50px rgba(0, 0, 0, 10%);
	border-style: groove;
}

.bi {
	color: black;
}

.bi:hover {
	color: white;
}

.b1 {
	color: white;
}

.abc {
	padding: 20px;
	color: white;
}

.abb:hover {
	color: black;
}


.container22{
	max-width: 400px;
	padding: 30px;
	margin-left:100px;
	background-color: rgba(255, 255, 255, 0.9);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
	text-align: center;
	margin-left: 350px;
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


caption {
	text-align: left;
	font-size: 1.2em;
	margin-bottom: 10px;
}

@keyframes fadeIn {from { opacity:0;
	
}

to {
	opacity: 1;
}
}
.inner{
margin-top: 100px;
margin-left: 350px;
}

.tableh{
background-color: black;
color: black;
}
</style>
</head>
<body>
		<nav class="navbar navbar-expand-lg ">
			<div class="container">
				<a href="Welcome.html" class="navbar-brand mx-auto mx-lg-0"> <span
					class="b1">MY</span> <i></i> <span class="bi">COURSE</span>
				</a>

				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ">
						<li class="nav-item">
						<li class="nav-item"><a class="nav-link click-scroll"
							href="logout"><img alt="" src="img/logout.png" height="20px"
								style="margin-left: 20px"> </a></li>

					</ul>
				</div>
			</div>
		</nav>
		<div style="margin-left:280px; margin-top:100px; width: 1000px;">
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
			<table class="table ">
				<tr class="tableh">
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
				<tr ">
					<%
					for (int i = 1; i <= j; i++) {
					%>
					<td style=" background-color:#e5eaec; text-align: left;"><%=res.getString(i)%></td>
					<%
					}
					%>
				</tr>
				<%
				}
				%>
			</table>
	
			<div class="container22 ">

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


</body>
</html>