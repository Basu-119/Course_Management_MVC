package com.digit.CourseManagement_MVC.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Professor {
	String pro_id;
	String pro_name;
	String pro_exp;
	String pro_sub;
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_exp() {
		return pro_exp;
	}

	public void setPro_exp(String pro_exp) {
		this.pro_exp = pro_exp;
	}

	public String getPro_sub() {
		return pro_sub;
	}

	public void setPro_sub(String pro_sub) {
		this.pro_sub = pro_sub;
	}
	 public Professor() {
		 String url = "jdbc:mysql://localhost:3306/course_mvc";
			String user = "root";
			String pwd = "root";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, pwd);
			} catch (Exception e) {

			}
	}
	 
	 
	 public boolean addProfessor() {

			try {String sql = "insert into professor values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			
				pstmt.setString(1, pro_id);

				pstmt.setString(2, pro_name);

				pstmt.setString(3, pro_exp);
				
				pstmt.setString(4, pro_sub);
				
				

				int x = pstmt.executeUpdate();

				if(x>0) {
					this.setPro_id(pro_id);
					this.setPro_name(pro_name);
					this.setPro_exp(pro_exp);
					this.setPro_sub(pro_sub);
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
	 public boolean removeProfessor(String rem_pro) {
			try {
				
				String sql1 = "delete from professor where pro_name=?";
				pstmt = con.prepareStatement(sql1);

				pstmt.setString(1, rem_pro);

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
