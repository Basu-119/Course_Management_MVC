package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CourseManagement_MVC.Model.ProfessorReq;
import com.digit.CourseManagement_MVC.Model.StudentReq;

@WebServlet("/AStudent")
public class ApproveStudent_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String appstu = req.getParameter("appstu");

		HttpSession session = req.getSession();
StudentReq sr=new StudentReq();

		if (sr.approveStu(appstu) == true) {
			resp.sendRedirect("/Course_Management_MVC/ApproveStudent.jsp");
		} else {
			resp.sendRedirect("/Course_Management_MVC/Welcome.html");

		}
	}
}
