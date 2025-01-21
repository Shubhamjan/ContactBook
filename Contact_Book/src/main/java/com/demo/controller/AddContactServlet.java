package com.demo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.demo.connection.DBConnection;
import com.demo.dao.ContactDao;
import com.demo.entity.Contact;

public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("userid is " + request.getParameter("userId"));
		int userId = Integer.parseInt(request.getParameter("userId"));

		String fname = request.getParameter("txtfirst");

		String lname = request.getParameter("txtlast");

		String email = request.getParameter("email");

		String number = request.getParameter("txtnumber");

		String about = request.getParameter("about");

		System.out.println(" " + fname + " " + lname);

		Contact c = new Contact(fname, lname, email, number, about, userId);

		ContactDao dao = new ContactDao(DBConnection.getConnection());

		boolean f = dao.saveContact(c);

		HttpSession session = request.getSession();

		if (f) {

			session.setAttribute("add", "Your Contact Saved Successfully");
			response.sendRedirect("addContact.jsp");
		} else {
			session.setAttribute("not", "Your Contact not Saved Successfully");
			response.sendRedirect("addContact.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
