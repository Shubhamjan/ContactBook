package com.demo.controller;

import com.demo.connection.DBConnection;
import com.demo.dao.UserDao;
import com.demo.entity.User;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

//@WebServlet("RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletRequest response) {
		
		
		String fname=request.getParameter("txtfirst");
		
		String lname=request.getParameter("txtlast");
		
		String email=request.getParameter("mail");
		
		String pass=request.getParameter("pass");
		
		String address=request.getParameter("txtaddress");
		
		String number=request.getParameter("txtnumber");
		
		String gen=request.getParameter("gen");
		
		User u=new User();
		
		u.setFirst_name(fname);
		u.setLast_name(lname);
		u.setEmail(email);
		u.setAddress(address);
		u.setMobile_number(number);
		u.setPassword(pass);
		u.setGender(gen);
		
		UserDao dao=new UserDao(DBConnection.getConnection());
		
		boolean flag=dao.userRegister(u);
		
		if(flag) {
			System.out.println("User resistred");
		}else {
			System.out.println("failed to registerd");
		}
	}
}
