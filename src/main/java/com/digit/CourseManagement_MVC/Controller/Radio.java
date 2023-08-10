package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Radio")
public class Radio extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession();

    String selectedOption = req.getParameter("radioOption");
	session.setAttribute("option",selectedOption);

resp.sendRedirect("/Course_Management_MVC/Added.jsp");	
}
}
