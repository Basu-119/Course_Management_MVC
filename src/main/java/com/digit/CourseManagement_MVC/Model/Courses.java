package com.digit.CourseManagement_MVC.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class Courses {

	String cou_id;
	String cou_name;
	String cou_time;
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;

	public String getCou_id() {
		return cou_id;
	}

	public void setCou_id(String cou_id) {
		this.cou_id = cou_id;
	}

	public String getCou_name() {
		return cou_name;
	}

	public void setCou_name(String cou_name) {
		this.cou_name = cou_name;
	}

	public String getCou_time() {
		return cou_time;
	}

	public void setCou_time(String cou_time) {
		this.cou_time = cou_time;
	}

	public Courses() {
		String url = "jdbc:mysql://localhost:3306/course_mvc";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {

		}
	}

	public boolean addCourse() {

		try {
			String sql = "insert into courses values(?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, cou_id);

			pstmt.setString(2, cou_name);

			pstmt.setString(3, cou_time + "months");

			int x = pstmt.executeUpdate();

			if (x > 0) {
				this.setCou_id(cou_id);
				this.setCou_name(cou_name);
				this.setCou_time(cou_time);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean removeCourse(String rem_cou) {
		try {
			String sql1 = "delete from courses where c_name=?";
			pstmt = con.prepareStatement(sql1);

			pstmt.setString(1, rem_cou);

			int x = pstmt.executeUpdate();
			if (x > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}