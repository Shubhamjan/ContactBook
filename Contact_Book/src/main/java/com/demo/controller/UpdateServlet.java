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


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid = Integer.parseInt(request.getParameter("cid"));

		String fname = request.getParameter("txtfirst");

		String lname = request.getParameter("txtlast");

		String email = request.getParameter("email");

		String number = request.getParameter("txtnumber");

		String about = request.getParameter("about");

		Contact c = new Contact();
		c.setFirst_name(fname);
		c.setLast_name(lname);
		c.setEmail(email);
		c.setPhone_number(number);
		c.setAbout(about);
		c.setContact_id(cid);
		ContactDao dao = new ContactDao(DBConnection.getConnection());
	
		boolean flag=dao.updateContact(c);
	
		HttpSession session = request.getSession();

		if (flag) {

			session.setAttribute("update", "Your Contact Updated Successfully");
			response.sendRedirect("viewContact.jsp");
		} else {
			session.setAttribute("notUpdate", "Your Contact not Updated Successfully");
			response.sendRedirect("edit.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
