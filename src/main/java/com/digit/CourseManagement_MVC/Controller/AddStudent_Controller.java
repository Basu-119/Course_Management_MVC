package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CourseManagement_MVC.Model.Student;

@WebServlet("/AddStudent")
public class AddStudent_Controller extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stu_id=req.getParameter("stu_id");
		String stu_name=req.getParameter("stu_name");
		String stu_cou=req.getParameter("stu_cou");
		HttpSession session=req.getSession();

		Student s=new Student();
		
		s.setStu_cou(stu_cou);
		s.setStu_id(stu_id);
		s.setStu_name(stu_name);
		
		boolean s1=s.addStudent();
		if(s1==true) {
			session.setAttribute("stu_id",s.getStu_id());
			session.setAttribute("stu_name",s.getStu_name());
			session.setAttribute("stu_cou",s.getStu_cou());
			resp.sendRedirect("Added.jsp");

		}
	}

}
