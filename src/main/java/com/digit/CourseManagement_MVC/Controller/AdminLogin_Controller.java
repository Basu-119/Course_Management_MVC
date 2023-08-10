package com.digit.CourseManagement_MVC.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import com.digit.CourseManagement_MVC.Model.Users;

@WebServlet("/admlogin")
public class AdminLogin_Controller extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String user_name = req.getParameter("user_name");
	String user_pass = req.getParameter("user_pass");

	
	Users user=new Users();
	if(user.admLogin(user_name, user_pass)==true) {
		resp.sendRedirect("/Course_Management_MVC/Welcome.html");
	}
	

}
}
