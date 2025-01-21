<%@ page import="com.demo.entity.User"%>


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand title" href="#"><i
			class="fa-sharp fa-solid fa-phone "></i> Contact Manager</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp"><i
						class="fa-sharp fa-solid fa-house"></i> Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="addContact.jsp"><i
						class="fa-sharp fa-solid fa-circle-plus"></i> Add Phone No</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="viewContact.jsp"><i class="fa-sharp fa-solid fa-eye"></i>
						View Contact</a></li>
			</ul>

			<%
			User user = (User) session.getAttribute("msg");

			if (user == null) {
			%>
			<form class="form-inline my-2 my-lg-0">
				<a href="login.jsp" class="btn btn-success"><i
					class="fa-sharp fa-solid fa-user"></i> Login</a> <a href="Register.jsp"
					class="btn btn-danger ml-2"><i
					class="fa-sharp fa-regular fa-user"></i> Register</a>
			</form>
			<%
			} else {
			%>
			<form class="form-inline my-2 my-lg-0">
				<button class="btn btn-warning"><%="Hi " + user.getFirst_name()%></button>
				<a data-bs-toggle="modal" data-bs-target="#exampleModalCenter"
					class="btn btn-danger ml-2">Logout</a>
			</form>
			<%
			}
			%>
			<!-- Logout pop out -->


			<!-- Modal -->
			<div class="modal fade" id="exampleModalCenter" tabindex="-1"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalCenterTitle">Contact Book</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body text-center">
							<h6>Do You Want Logout....</h6>
						
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<a type="button" href="LogoutServlet"class="btn btn-primary">Logout</a>
						</div>
						<div class="modal-footer"></div>
					</div>
				</div>
			</div>

			<!-- Logout pop out -->
		</div>
	</div>
</nav>