package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.CourseManagement_MVC.Model.Professor;

@WebServlet("/DeleteProfessor")
public class DeleteProfessor_Controller extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rem_pro = req.getParameter("rem_pro");
		Professor p2 = new Professor();
		if (p2.removeProfessor(rem_pro)) {
			resp.sendRedirect("Added.jsp");

		}

	}
}
