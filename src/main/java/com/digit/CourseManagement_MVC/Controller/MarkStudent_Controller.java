package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CourseManagement_MVC.Model.StudentMark;

@WebServlet("/mark")
public class MarkStudent_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selstu = req.getParameter("selstu");
		HttpSession session = req.getSession();
		int mark = Integer.parseInt(req.getParameter("getmark"));

		String grade;
		String remark;
		if (mark >= 90) {
			grade = "A+";
			remark = "OutStanding";
		} else if (mark >= 80 && mark < 90) {
			grade = "A";
			remark = "Excellent";

		} else if (mark >= 70 && mark < 80) {
			grade = "B";
			remark = "Very Good";

		} else if (mark >= 60 && mark < 70) {
			grade = "C";
			remark = "Good";

		} else if (mark >= 50 && mark < 60) {
			grade = "D";
			remark = "Average";

		} else if (mark >= 40 && mark < 50) {
			grade = "E";
			remark = "Bad";

		} else {
			grade = "F";
			remark = "Very Bad";

		}

		StudentMark sm = new StudentMark();
		sm.setStu_name(selstu);
		sm.setStu_grade(grade);
		sm.setStu_mark(mark);
		sm.setStu_fmakr(100);
		sm.setStu_remark(remark);
		session.setAttribute("selstu", sm.getStu_name());
		session.setAttribute("grade", sm.getStu_grade());
		session.setAttribute("mark", sm.getStu_mark());
		session.setAttribute("fmark", 100);
		session.setAttribute("remark", sm.getStu_remark());

		if (sm.addMarks() == true) {
			resp.sendRedirect("/Course_Management_MVC/Student_Mark.jsp");
		}
		else {
			resp.sendRedirect("/Course_Management_MVC/Welcome.html");
	
		}
	}
}
