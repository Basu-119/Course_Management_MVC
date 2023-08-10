package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CourseManagement_MVC.Model.ProfessorReq;

@WebServlet("/ProRegister")
public class ProRegitser_Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	HttpSession session = req.getSession();

	String pro_name=req.getParameter("pro_name");
	String user_name=req.getParameter("user_name");
	String user_pass=req.getParameter("user_pass");
	String pro_sub=req.getParameter("pro_sub");
	String pro_exp=req.getParameter("pro_exp");
	session.setAttribute("req_pro_name", pro_name);

	ProfessorReq pr1=new ProfessorReq();
	pr1.setPro_name(pro_name);;
	pr1.setUser_name(user_name);
	pr1.setUser_pass(user_pass);
	pr1.setPro_sub(pro_sub);
	pr1.setPro_exp(pro_exp);
	
	if(pr1.ProReg()== true) {
		resp.sendRedirect("ReqApp.jsp");
	}
	
	
}
}
