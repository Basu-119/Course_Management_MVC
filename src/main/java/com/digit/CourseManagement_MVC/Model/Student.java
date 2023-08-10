package com.digit.CourseManagement_MVC.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Student {

	String stu_id;
	String stu_name;
	String stu_cou;
	private Connection con;
	private PreparedStatement pstmt;
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getStu_cou() {
		return stu_cou;
	}
	public void setStu_cou(String stu_cou) {
		this.stu_cou = stu_cou;
	}
	
	public Student() {
		String url = "jdbc:mysql://localhost:3306/course_mvc";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {

		}
	}
	
	public boolean addStudent() {

		try {String sql = "insert into student values(?,?,?,?)";
		pstmt = con.prepareStatement(sql);

		
			pstmt.setString(1, stu_id);

			pstmt.setString(2, stu_name);

			pstmt.setString(3, stu_cou);
			
			pstmt.setString(4, "notmarked");
			
			

			int x = pstmt.executeUpdate();

			if(x>0) {
				this.setStu_cou(stu_cou);
				this.setStu_id(stu_id);;
				this.setStu_name(stu_name);
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
	public boolean removeStudent(String rem_stu) {
		try {
			String sql1 = "delete from student where stu_name=?";
			pstmt = con.prepareStatement(sql1);

			pstmt.setString(1, rem_stu);

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
