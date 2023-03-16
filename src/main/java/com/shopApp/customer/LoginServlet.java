package com.shopApp.customer;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		String uname=req.getParameter("uname");
		String pass=req.getParameter("pass");
		boolean val=Validator.isValid(uname,pass);
		if(val==true && uname.equals("admin")) 
			res.sendRedirect("admin.jsp");
		else if(val==true)
			res.sendRedirect("home.jsp");
		else
			res.sendRedirect("login.jsp");
	} 
	
}
