<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
	<%@include file="navigation.jsp" %>
	
	<div class="container py-5">
		<h1 class="text-center mb-4">Create new user</h1>
		<hr class="mx-auto" style="width:50%;">

		<div class="d-flex flex-column align-items-center py-5">
			<form action="manage_user" method="post" style="width:350px;" onsubmit="return validateFormInput();">
				<div class="form-floating mb-3">
				  <input name="email" type="email" class="form-control" id="inputUserEmail" placeholder="name@example.com">
				  <label for="inputUserEmail">Email address</label>
				</div>
				<div class="form-floating mb-3">
				  <input name="fullName" type="text" class="form-control" id="inputUserFullname" placeholder="Full name">
				  <label for="inputUserFullname">Full name</label>
				</div>
				<div class="form-floating mb-3">
				  <input name="password" type="password" class="form-control" id="inputUserPassword" placeholder="Password">
				  <label for="inputUserPassword">Password</label>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mt-4 w-50">Sign in</button>
				</div>
			</form>
		</div>
		
	</div>
	
<script type="text/javascript">
 	function validateFormInput() {
 		var fieldEmail = document.getElementById("inputUserEmail");
 		var fieldFullname = document.getElementById("inputUserFullname");
 		var fieldPassword = document.getElementById("inputUserPassword");
 		
 		if (fieldEmail.value.length == 0) {
 			fieldEmail.classList.add("is-invalid");
 			return false;
 		} else {
 			fieldEmail.classList.remove("is-invalid");
 			fieldEmail.classList.add("is-valid");
 		}
 		
 		if (fieldFullname.value.length == 0) {
 			fieldFullname.classList.add("is-invalid");
 			return false;
 		} else {
 			fieldFullname.classList.remove("is-invalid");
 			fieldFullname.classList.add("is-valid");
 		}
 		
 		if (fieldPassword.value.length == 0) {
 			fieldPassword.classList.add("is-invalid");
 			return false;
 		} else {
 			fieldPassword.classList.remove("is-invalid");
 			fieldPassword.classList.add("is-valid");
 		}
 		
 		return true;
 	}
</script>

	
<%@include file="footer.jsp" %>