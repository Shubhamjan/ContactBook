




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Component/allCss.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Book</title>
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

	<div class="container-fluid">

		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success fw-bolder">Add Contact</h4>
						
						<% String add=(String)session.getAttribute("add");
								String not=(String)session.getAttribute("not");
							if(add!=null){
								%>
								
								<p class="text-success text-center"><%= add %></p>
							<% 
							session.removeAttribute("add");
							}
							if(not!=null){
								%>
								<p class="text-danger text-center"><%= not %></p>
								<%
								session.removeAttribute("not");
							}
							%>

						<form action="AddContactServlet" method="post">

							<%
							
							if (user != null) {
							%>
							<input type="hidden" value="<%=user.getId()%>" name="userId">
							<%
							}
							%>

							<div class="mb-3">
								<label for="fn" class="form-label">First Name</label> <input
									type="text" class="form-control" id="fn" name="txtfirst"
									required placeholder="Enter the first name">
							</div>
							<div class="mb-3">
								<label for="ln" class="form-label">Last Name</label> <input
									type="text" class="form-control" id="ln" name="txtlast"
									required placeholder="Enter the last name">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" required
									placeholder="Enter the email id" name="email">
							</div>


							<div class="mb-3">
								<label for="mo" class="form-label">Phone Number</label> <input
									type="text" class="form-control" id="mo" name="txtnumber"
									required placeholder="Enter the mobile number">
							</div>

							<div class="form-floating">
								<textarea class="form-control"
									placeholder="Leave a comment here" id="floatingTextarea2"
									style="height: 100px" name="about"></textarea>
								<label for="floatingTextarea2">About</label>
							</div>
							<div class="text-center mt-4">
								<button type="submit" class="btn btn-primary">Add To
									Contact</button>
							</div>

						</form>
					</div>


				</div>
			</div>

		</div>

	</div>
	<%@ include file="Component/footer.jsp"%>
</body>
</html>