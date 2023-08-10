package com.digit.CourseManagement_MVC.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProfessorReq {
	String user_name;
	String pro_name;
	String user_pass;
	String pro_sub;
	String pro_exp;
	private PreparedStatement pstmt;
	private ResultSet res;
	private PreparedStatement pstmt2;
	private static Connection con;
	private static PreparedStatement pstmt1;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	public String getPro_sub() {
		return pro_sub;
	}

	public void setPro_sub(String pro_sub) {
		this.pro_sub = pro_sub;
	}

	public String getPro_exp() {
		return pro_exp;
	}

	public void setPro_exp(String pro_exp) {
		this.pro_exp = pro_exp;
	}

	public ProfessorReq() {
		String url = "jdbc:mysql://localhost:3306/course_mvc";
		String user = "root";
		String pwd = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);

		} catch (Exception e) {

		}
	}

	public boolean approvePro(String Proname) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/course_mvc";
			String user = "root";
			String pwd = "root";
			Connection con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt;
			String sql = "select * from prorequest where pro_name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Proname);

			res = pstmt.executeQuery();
			if (res.next()) {
				String username = res.getString("user_name");
				String pro_name = res.getString("pro_name");
				String user_pass = res.getString("user_pass");

				String pro_sub = res.getString("pro_sub");
				String pro_exp = res.getString("pro_exp");

				String sql1 = "insert into professor values(?,?,?,?)";
				pstmt1 = con.prepareStatement(sql1);

				pstmt1.setString(1, username);

				pstmt1.setString(2, Proname);
				pstmt1.setString(3, pro_sub);
				pstmt1.setString(4, pro_exp);

				String sql5 = "insert into users values(?,?,?)";
				pstmt2 = con.prepareStatement(sql5);

				pstmt2.setString(1, username);

				pstmt2.setString(2, user_pass);
				pstmt2.setString(3, "professor");

				int x4 = pstmt2.executeUpdate();
				int x = pstmt1.executeUpdate();
				if (x > 0) {
					String sql4 = "delete from prorequest where pro_name=?";
					pstmt = con.prepareStatement(sql4);

					pstmt.setString(1, Proname);

					int x1 = pstmt.executeUpdate();

					if (x1 > 0) {
						return true;
					}
				}

			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean rejPro() {
		try {

			String sql1 = "delete from professor where pro_name=?";
			pstmt = con.prepareStatement(sql1);

			pstmt.setString(1, getPro_name());

			int x = pstmt.executeUpdate();
			if (x > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean ProReg() {
		try {

			String sql = "insert into prorequest values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, getUser_name());

			pstmt.setString(2, getPro_name());
			pstmt.setString(3, getUser_pass());
			pstmt.setString(4, getPro_sub());
			pstmt.setString(5, getPro_exp());
			pstmt.setString(6, "Professor");

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
