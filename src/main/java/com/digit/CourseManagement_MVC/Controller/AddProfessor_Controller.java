package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CourseManagement_MVC.Model.Professor;

@WebServlet("/AddProfessor")
public class AddProfessor_Controller extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String pro_id=req.getParameter("pro_id");
	String pro_name=req.getParameter("pro_name");
	String pro_exp=req.getParameter("pro_exp");
	String pro_sub=req.getParameter("pro_sub");
	HttpSession session = req.getSession();
	
	Professor p= new Professor();
	p.setPro_name(pro_name);
	p.setPro_id(pro_id);
	p.setPro_sub(pro_sub);
	p.setPro_exp(pro_exp);
	
	boolean p1=p.addProfessor();
	if(p1==true) {
		session.setAttribute("pro_id", p.getPro_id());
		session.setAttribute("pro_name", p.getPro_name());
		session.setAttribute("pro_exp", p.getPro_exp());
		session.setAttribute("pro_sub", p.getPro_sub());
		resp.sendRedirect("Added.jsp");

	}
}
}
