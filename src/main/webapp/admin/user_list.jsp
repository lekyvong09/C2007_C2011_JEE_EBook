<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
	<%@include file="navigation.jsp" %>
	
	<div class="container py-5">
		<h1 class="text-center mb-4">User Management</h1>
		<hr class="mx-auto" style="width:50%;">
		
		<h2 class="text-center">Quick action</h2>
		<div class="d-flex justify-content-center">
			<a href="user_form.jsp" class="me-4">New User</a>
		</div>
		<hr class="mx-auto" style="width:50%;">
		
		<div class="table-responsive py-3">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Index</th>
						<th>ID</th>
						<th>Email</th>
						<th>Full name</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${userList}" var="user" varStatus="count">
						<tr>
							<td>${count.index + 1}</td>
							<td>${user.userId }</td>
							<td>${user.email }</td>
							<td>${user.fullName }</td>
							<td>
								<a href="#">Edit</a>
								<span class="mx-3"> | </span>
								<a href="#">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
		
		
	</div>
	
<%@include file="footer.jsp" %>