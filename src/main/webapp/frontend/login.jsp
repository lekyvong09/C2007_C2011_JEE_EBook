<%@include file="header.jsp" %>

</head>
<body>
	<%@include file="navigation.jsp" %>
	
	<div class="container py-5">
		<div class="d-flex flex-column align-items-center">
			<div style="width:350px;">
				<h2 class="text-center">Please login</h2>
				<div class="form-floating mb-3">
				  <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
				  <label for="floatingInput">Email address</label>
				</div>
				<div class="form-floating">
				  <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
				  <label for="floatingPassword">Password</label>
				</div>
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mt-4 w-50">Sign in</button>
				</div>
			</div>
			
		</div>	
	</div>
	
<%@include file="footer.jsp" %>