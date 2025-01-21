package com.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.demo.connection.DBConnection;
import com.demo.dao.UserDao;
import com.demo.entity.User;

//@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fname = request.getParameter("txtfirst");

		String lname = request.getParameter("txtlast");

		String email = request.getParameter("mail");

		String pass = request.getParameter("pass");

		String address = request.getParameter("txtaddress");

		String number = request.getParameter("txtnumber");

		String gen = request.getParameter("gen");

		User u = new User();

		u.setFirst_name(fname);
		u.setLast_name(lname);
		u.setEmail(email);
		u.setAddress(address);
		u.setMobile_number(number);
		u.setPassword(pass);
		u.setGender(gen);

		UserDao dao = new UserDao(DBConnection.getConnection());

		boolean flag = dao.userRegister(u);
		
		HttpSession session=request.getSession();
		

		if (flag) {
			System.out.println("User resistred");
			session.setAttribute("success", "User Registered successfully");
			response.sendRedirect("Register.jsp");
		} else {
			System.out.println("failed to registerd");
			session.setAttribute("err", "failed to registerd");
			response.sendRedirect("Register.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
