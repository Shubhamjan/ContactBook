<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Component/allCss.jsp"%>
<%@ page import="com.demo.entity.Contact"%>
<%@ page import="com.demo.dao.ContactDao"%>
<%@ page import="com.demo.connection.DBConnection"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Book</title>
<style>
.card-st {
	transition: transform 0.3s ease, background-color 0.3s ease;
	/* Smooth transition for size and color */
}

.card-st:hover {
	transform: scale(1.05);
	background-color: #c9cdd4;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
}
</style>

</head>
<body>
	<%@ include file="Component/navbar.jsp"%>
	<%
	if (user == null) {
		HttpSession s = request.getSession();
		s.setAttribute("restrict", "Please Login");
		response.sendRedirect("login.jsp");
	}
	%>

	<%
	String success = (String) session.getAttribute("update");

	if (success != null) {
	%>
	<div class="alert alert-success" role="alert"><%= success%></div>
	<%
	session.removeAttribute("update");
	}
	
	String delete=(String)session.getAttribute("delete");
	String fail=(String)session.getAttribute("notDelete");
	
	if(delete!=null){
		%>
		<div class="alert alert-success" role="alert"><%= delete%></div>
	<%
	}
	if(fail!=null){
		%>
	<div class="alert alert-danger" role="alert"><%= fail%></div>
	<% 
	}
	%>



	<div class="container">
		<div class="row p-4">


			<%
			if (user != null) {
			%>
			<%
			ContactDao dao = new ContactDao(DBConnection.getConnection());
			List<Contact> lst = dao.getAllContact(user.getId());

			for (Contact c : lst) {
				System.out.println(c);
			%>
			<div class="col-md-3">
				<div class="card card-st mb-4">
					<div class="card-body">
						<h3 class="text-center">
							<%=c.getFirst_name() + " " + c.getLast_name()%></h3>
						<p>
							Phone no:
							<%=c.getPhone_number()%></p>
						<p>
							Email:<%=c.getEmail()%></p>
						<p>
							About:<%=c.getAbout()%></p>
					</div>
					<div class="text-center mb-3">

						<a href="edit.jsp?cid=<%=c.getContact_id()%>"
							class="btn btn-warning btn-sm text-white me-2">Edit</a> 
							<a href="DeleteServlet?cid=<%=c.getContact_id()%>"class="btn btn-danger btn-sm text-white">Delete</a>
					</div>

				</div>
			</div>
			<%
			}
			%>


			<%
			}
			%>





		</div>


	</div>
	<%@ include file="Component/footer.jsp"%>
</body>
</html>