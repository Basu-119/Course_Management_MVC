package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CourseManagement_MVC.Model.Student;

@WebServlet("/DeleteStudent")
public class DeleteStudent_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rem_stu = req.getParameter("rem_stu");
		Student s2 = new Student();
		if (s2.removeStudent(rem_stu)) {
			resp.sendRedirect("Added.jsp");

		}

	}
}
