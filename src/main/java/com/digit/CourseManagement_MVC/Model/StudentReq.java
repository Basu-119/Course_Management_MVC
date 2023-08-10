package com.digit.CourseManagement_MVC.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentReq {
	String user_name;
	String stu_name;
	String user_pass;
	String stu_cou;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	private PreparedStatement pstmt1;
	private PreparedStatement pstmt4;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getStu_cou() {
		return stu_cou;
	}

	public void setStu_cou(String stu_cou) {
		this.stu_cou = stu_cou;
	}

	public StudentReq() {
		String url = "jdbc:mysql://localhost:3306/course_mvc";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {

		}
	}
	
	public boolean StuReg() {
		try {

			String sql = "insert into sturequest values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, getUser_name());

			pstmt.setString(2, getStu_name());
			pstmt.setString(3, getUser_pass());
			pstmt.setString(4, getStu_cou());
			pstmt.setString(5, "Student");

			int x = pstmt.executeUpdate();
			if (x > 0) {
				return true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean rejStu() {
		try {

			String sql1 = "delete from sturequest where stu_name=?";
			pstmt = con.prepareStatement(sql1);

			pstmt.setString(1,getStu_name() );

			int x = pstmt.executeUpdate();
			if (x > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean approveStu(String Stuname) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/course_mvc";
			String user = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt;
			String sql = "select * from sturequest where stu_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Stuname);

			res = pstmt.executeQuery();
			res.next();
			String username = res.getString("user_name");
			String stu_name = res.getString("stu_name");
			String user_pass = res.getString("user_pass");
			String stu_cou = res.getString("stu_cou");

			String sql1 = "insert into student values(?,?,?,?)";
			pstmt1 = con.prepareStatement(sql1);

			pstmt1.setString(1, username);

			pstmt1.setString(2, stu_name);
			pstmt1.setString(3, stu_cou);
			pstmt1.setString(4, "notmarked");

			int x3 = pstmt1.executeUpdate();
			
			String sql5 = "insert into users values(?,?,?)";
			pstmt4 = con.prepareStatement(sql5);

			pstmt4.setString(1, username);

			pstmt4.setString(2, user_pass);
			pstmt4.setString(3, "student");

			int x = pstmt4.executeUpdate();
			if(x>0) {
				String sql4 = "delete from sturequest where stu_name=?";
				pstmt = con.prepareStatement(sql4);

				pstmt.setString(1, Stuname);

				int x1 = pstmt.executeUpdate();
				
				if (x1 > 0) {
					return true;
				}	
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}
