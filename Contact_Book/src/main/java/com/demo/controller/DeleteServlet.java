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


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int cid=Integer.parseInt(request.getParameter("cid"));
		
		ContactDao dao=new ContactDao(DBConnection.getConnection());
		
		boolean flag= dao.deleteContactById(cid);
		
		HttpSession session=request.getSession();
		
		
		if(flag) {
			session.setAttribute("delete", "Contact deleted successfully");
			response.sendRedirect("viewContact.jsp");
		}else {
			session.setAttribute("notDelete", "Failed to delete the contact ");
			response.sendRedirect("viewContact.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
