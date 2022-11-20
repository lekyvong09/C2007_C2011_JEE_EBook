<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!-- CSS -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
	<!-- Bootstrap theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
	
</head>
<body>
	
	<c:if test="${message != null }" >
		<input id="notification" type="hidden" value="${message }">
	</c:if>
	
	<div class="container py-5">
		<form id="adminLoginForm" method="post" action="login" class="d-flex flex-column align-items-center">
			<div style="width:350px;">
				<h2 class="text-center">Please login</h2>
				<div class="form-floating mb-3">
				  <input name="email" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
				  <label for="floatingInput">Email address</label>
				  <div class="invalid-feedback">Please input valid email address</div>
				</div>
				<div class="form-floating">
				  <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password">
				  <label for="floatingPassword">Password</label>
				  <div class="invalid-feedback">Please input valid password</div>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mt-4 w-50">Sign in</button>
				</div>
			</div>
			
		</form>	
	</div>
	
	<%@include file="footer.jsp" %>

	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
	
	<!-- j-query validation library must be before the java-script code -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	
	<script type="text/javascript">
		var notification = document.getElementById("notification");
	
		if (notification != null && notification.value.length > 0) {
			// console.log(notification.value);
			alertify.error(notification.value);
		}
	</script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#adminLoginForm").validate({
				rules: {
					email: { required: true, email: true },
					password: { required: true },
				},
				/* add bootstrap class is-valid & is-invalid */
				highlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "is-invalid" ).removeClass( "is-valid" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).addClass( "is-valid" ).removeClass( "is-invalid" );
				},
				/* hide default label error message of jquery-validation */
				errorPlacement: function(error, element) { }
			});
		})
	</script>

</body>
</html>