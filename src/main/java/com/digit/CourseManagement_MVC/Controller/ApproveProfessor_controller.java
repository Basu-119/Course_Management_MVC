package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.CourseManagement_MVC.Model.ProfessorReq;

@WebServlet("/approvePro")
public class ApproveProfessor_controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String apppro =  req.getParameter("apppro");

		HttpSession session = req.getSession();

		ProfessorReq pr = new ProfessorReq();
		if (pr.approvePro(apppro) == true) {
resp.sendRedirect("/Course_Management_MVC/ApproveProfessor.jsp");
		}
		else {
			resp.sendRedirect("/Course_Management_MVC/Welcome.html");

		}
	}
}
