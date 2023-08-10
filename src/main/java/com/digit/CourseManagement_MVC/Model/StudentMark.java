package com.digit.CourseManagement_MVC.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentMark {
	String stu_id;
	String stu_name;
	String stu_cour;
	int stu_fmakr;
	int stu_mark;
	String stu_grade;
	String stu_remark;
	private Connection con;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt1;
	private PreparedStatement pstmt2;
	private ResultSet resultSet;

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

	public String getStu_cour() {
		return stu_cour;
	}

	public void setStu_cour(String stu_cour) {
		this.stu_cour = stu_cour;
	}

	public int getStu_fmakr() {
		return stu_fmakr;
	}

	public void setStu_fmakr(int stu_fmakr) {
		this.stu_fmakr = stu_fmakr;
	}

	public int getStu_mark() {
		return stu_mark;
	}

	public void setStu_mark(int stu_mark) {
		this.stu_mark = stu_mark;
	}

	public String getStu_grade() {
		return stu_grade;
	}

	public void setStu_grade(String stu_grade) {
		this.stu_grade = stu_grade;
	}

	public String getStu_remark() {
		return stu_remark;
	}

	public void setStu_remark(String stu_remark) {
		this.stu_remark = stu_remark;
	}

	public StudentMark() {
		String url = "jdbc:mysql://localhost:3306/course_mvc";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {

		}

	}

	public boolean addMarks() {

		try {
			String s_id;
			String s_cour;
			String sql4 = "select * from student where stu_name=?";
			pstmt2 = con.prepareStatement(sql4);
			pstmt2.setString(1, getStu_name());

			resultSet = pstmt2.executeQuery();
			resultSet.next();
			s_id = resultSet.getString("stu_id");
			s_cour = resultSet.getString("stu_cou");

			String sql = "insert into studentmark values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, s_id);

			pstmt.setString(2, getStu_name());

			pstmt.setString(3, s_cour);
			pstmt.setInt(4, getStu_fmakr());
			pstmt.setInt(5, getStu_mark());
			pstmt.setString(6, getStu_grade());
			pstmt.setString(7, getStu_remark());
			pstmt.setString(8, "Marked");
			String sql1 = "update student set status='marked' where stu_name=?";
			pstmt1 = con.prepareStatement(sql1);

			pstmt1.setString(1, getStu_name());

			int x = pstmt1.executeUpdate();
			int x1 = pstmt.executeUpdate();

			if (x1 > 0) {

				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
