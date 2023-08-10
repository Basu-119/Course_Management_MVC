package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CourseManagement_MVC.Model.Courses;

@WebServlet("/DeleteCourse")
public class DeleteCourse_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rem_cou = req.getParameter("rem_cou");
		Courses c = new Courses();
		if (c.removeCourse(rem_cou) == true) {
			resp.sendRedirect("Added.jsp");

		}

	}
}
