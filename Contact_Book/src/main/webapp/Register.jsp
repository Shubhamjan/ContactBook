<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="Component/allCss.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#e6e6e6;">
	<%@ include file="Component/navbar.jsp"%>

	<div class="container-fluid">

		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success fw-bolder">Registration Page</h4>
						
						<%String msg=(String)session.getAttribute("success"); 
						 String err=(String)session.getAttribute("err");
						if(msg!=null){
							%>
							<p class="text-success text-center"><%=msg %></p>
						<% 
						session.removeAttribute("success");
						}
						
						if(err!=null){
						%>
						<p class="text-danger text-center"><%=err %></p>
							<% 
							session.removeAttribute("success");
						}
						%>
						
						<form action="RegistrationServlet" method="post">
							<div class="mb-3">
								<label for="fn" class="form-label">First Name</label> <input
									type="text" class="form-control" id="fn" name="txtfirst" required placeholder="Enter the first name">
							</div>
							<div class="mb-3">
								<label for="ln" class="form-label">Last Name</label> <input
									type="text" class="form-control" id="ln" name="txtlast" required placeholder="Enter the last name">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" name="mail" required placeholder="Enter the email id">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" name="pass" required placeholder="Enter the password">
							</div>
							<div class="mb-3">
								<label for="add" class="form-label">Address</label> <input
									type="text" class="form-control" id="add" name="txtaddress" required placeholder="Enter the address">
							</div>
							<div class="mb-3">
								<label for="mo" class="form-label">Mobile Number</label> <input
									type="text" class="form-control" id="mo" name="txtnumber" required placeholder="Enter the mobile number">
							</div>
							<fieldset class="row mb-3">
								<legend class="col-form-label col-sm-2 pt-0">Gender</legend>
								<div class="col-sm-10">
									<div class="form-check">
										<input class="form-check-input" type="radio" name="gen"
											id="gridRadios1" value="Male" checked> <label
											class="form-check-label" for="gridRadios1"> Male</label>
									</div>
									<div class="form-check">
										<input class="form-check-input" type="radio" name="gen"
											id="gridRadios2" value="Female"> <label
											class="form-check-label" for="gridRadios2"> Female </label>
									</div>
									
								</div>
							</fieldset>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>

						</form>
					</div>


				</div>
			</div>

		</div>

	</div>
	<div style="margin-top:100px">
	<%@ include file="Component/footer.jsp" %>
	</div>
</body>
</html>