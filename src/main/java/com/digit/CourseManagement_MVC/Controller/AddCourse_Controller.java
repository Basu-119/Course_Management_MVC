package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CourseManagement_MVC.Model.Courses;

@WebServlet("/AddCourse")
public class AddCourse_Controller extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();

		String cou_id=req.getParameter("cou_id");
		String cou_name=req.getParameter("cou_name");
		String cou_time=req.getParameter("cou_time");

		Courses c=new Courses();
		c.setCou_id(cou_id);
		c.setCou_name(cou_name);
		c.setCou_time(cou_time);
		boolean c1= c.addCourse();
		if(c1==true) {
			session.setAttribute("cou_id",c.getCou_id());
			session.setAttribute("cou_name",c.getCou_name());
			session.setAttribute("cou_time",c.getCou_time());
			resp.sendRedirect("Added.jsp");
 
		}
	}
}
