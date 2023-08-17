<%@page import="com.digit.CourseManagement_MVC.Model.StudentMark"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.mysql.cj.jdbc.result.ResultSetMetaData"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<style type="text/css">
html {
	font-family: arial;
	font-size: 18px;
}

td {
	border: 1px solid #726E6D;
	padding: 15px;
}

thead {
	font-weight: bold;
	text-align: center;
	background: #625D5D;
	color: white;
}

table {
	border-collapse: collapse;
	min-width: 500px;
}

.footer {
	text-align: right;
	font-weight: bold;
}

tbody>tr:nth-child(odd) {
	background: #D1D0CE;
}
tab1  { position:absolute;left:1090px;  }

.ps {
padding-left: 100px;
}
</style>
</head>

<body>

	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/course_mvc";
		String user = "root";
		String pwd = "root";
		Connection con = DriverManager.getConnection(url, user, pwd);
		ResultSetMetaData metadata;
		PreparedStatement pstmt;
		String sql = "select * from studentmark where stu_name=?";
		String stu_name = request.getParameter("show_stu");
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, stu_name);

		ResultSet res = pstmt.executeQuery();
		res.next();
		String s_id = res.getString("stu_id");
		String s_name = res.getString("stu_name");
		String s_cour = res.getString("stu_cour");
		int s_fmark = Integer.parseInt(res.getString("stu_fmark"));
		int s_mark = Integer.parseInt(res.getString("stu_mark"));
		String s_grade = res.getString("stu_grade");
		String s_remark = res.getString("stu_remark");
	%>
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->

		<!-- Main content -->
		<section class="content">
			<div class="box box-warning">
				<!-- /.box-header -->
				<div class="box-body">


					<div class="container">
						<div class="jumbotron">
							<div style="margin-left: 160px;" class="text-center">
								<h2 style="line-height: 0.6; margin-left: 500px">D I G I T
									&nbsp; O F F I C E</h2>
								<h4 style="line-height: 0.6; margin-left: 550px">
									<strong>B A N G L O R E</strong>
								</h4>
								<h4 style="line-height: 0.6; margin-left: 550px">REPORT
									CARD</h4>
								<span style="line-height: 0.6; margin-left: 590px">2 0 2
									3</span>
							</div>

							<br> <br> <br>
							<div class="row">
								<div class="col-sm-6" style="float: left;">
									<label>Name :</label> <span id="Name" name="student_Name">
										<%
										out.print(s_name);
										%>
									</span> <br>
								</div>
								<div class="col-sm-6" style="float: right;">
									<label>Roll No :</label> <span id="rollNo" name="RollNumber">
										<%
										out.print(s_id);
										%>
									</span> <br>
								</div>

							</div>
							<br> <br>




							<table width="100%">
								<thead>
									<tr>
										<td colspan="3">Student</td>
										<td colspan="4">Mark</td>
									</tr>
									<tr>
										<td>Student ID</td>
										<td colspan="2">Student Name</td>
										<td>Full Mark</td>
										<td>Mark</td>
										<td>Grade</td>
										<td>Remark</td>

									</tr>
								</thead>

								<tbody>



									<tr>
										<td>
											<%
											out.print(s_id);
											%>
										</td>
										<td colspan="2">
											<%
											out.print(s_name);
											%>
										</td>
										<td>
											<%
											out.print(s_fmark);
											%>
										</td>
										<td>
											<%
											out.print(s_mark);
											%>
										</td>
										<td>
											<%
											out.print(s_grade);
											%>
										</td>
										<td>
											<%
											out.print(s_remark);
											%>
										</td>

									</tr>

								</tbody>

								<tfoot>
									<tr>
										<td colspan="3" class="footer">PERCENTAGE</td>
										<td colspan="4">
											<%
											out.print(s_mark);
											%>%
										</td>
									</tr>
							</table>



						</div>
					</div>


				</div>
			</div>
			
			
				<br>
				<br><br>
				<h5>PARENT SIGNATURE <tab1> PRINCIPAL SIGNATURE </h5>
				
				
			

		</section>
	</div>

	<%
	} catch (Exception e) {

	}
	%>
</body>
</html>