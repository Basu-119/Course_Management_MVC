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

@WebServlet("/StuRegister")
public class StudentReq_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String stu_name = req.getParameter("stu_name");
		String user_name = req.getParameter("user_name");
		String user_pass = req.getParameter("user_pass");
		String stu_cou = req.getParameter("stu_cou");
		session.setAttribute("req_stu_name", stu_name);

		StudentReq s3 = new StudentReq();
		s3.setStu_name(stu_name);
		s3.setUser_name(user_name);
		s3.setUser_pass(user_pass);
		s3.setStu_cou(stu_cou);
		if (s3.StuReg() == true) {
			resp.sendRedirect("Reqstu.jsp");
		}

	}
}
