package com.digit.CourseManagement_MVC.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Users {

	String user_name;
	String user_pass;
	String role;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Users() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/course_mvc";
			String user = "root";
			String pwd = "root";
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public boolean admLogin(String user_name, String user_pass) {
		try {
			String sql = "select * from users where user_name=? and user_pass=? and role=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, user_pass);
			pstmt.setString(3, "admin");
			res = pstmt.executeQuery();
			if (res.next()) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean stuLogin(String user_name, String user_pass) {
		try {
			String sql = "select * from users where user_name=? and user_pass=? and role=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, user_pass);
			pstmt.setString(3, "student");
			res = pstmt.executeQuery();
			if (res.next()) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public boolean proLogin(String user_name, String user_pass) {
		try {
			String sql = "select * from users where user_name=? and user_pass=? and role=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, user_pass);
			pstmt.setString(3, "professor");
			res = pstmt.executeQuery();
			if (res.next()) {
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}