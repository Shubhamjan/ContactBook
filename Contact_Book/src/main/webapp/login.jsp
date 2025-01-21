<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Component/allCss.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Book</title>


</head>
<body style="background-color:#e6e6e6;">
	<%@ include file="Component/navbar.jsp"%>

	<div class="container-fluid">

		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success fw-bolder">Login Page</h4>
						<form action="LoginServlet" method="post">
							
							<% String msg=(String)session.getAttribute("err");
								String restrict=(String)session.getAttribute("restrict");
							if(msg!=null){
								%>
								
								<p class="text-danger text-center"><%= msg %></p>
							<% 
							session.removeAttribute("err");
							}
							if(restrict!=null){
								%>
								<p class="text-danger text-center"><%= restrict %></p>
								<%
								session.removeAttribute("restrict");
							}
							%>
							
							
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" required placeholder="Enter the email id" name="email">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" required placeholder="Enter the password" name="pass">
							</div>
							
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Login</button>
								
							</div>
								
						</form>
					</div>


				</div>
			</div>

		</div>

	</div>
	<div style="margin-top:265px">
	<%@ include file="Component/footer.jsp" %>
	</div>
</body>
</html>