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


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email=request.getParameter("email");
		
		String pass=request.getParameter("pass");
		
		UserDao dao=new UserDao(DBConnection.getConnection());
		
		User u=dao.loginUser(email, pass);
		
		HttpSession session=request.getSession();
		
		if(u!=null) {
			
			session.setAttribute("msg", u);
			response.sendRedirect("index.jsp");
			System.out.println("User is available");
		}else {
			
			session.setAttribute("err","invalid user" );
			response.sendRedirect("login.jsp");
			System.out.println("User not availble");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
