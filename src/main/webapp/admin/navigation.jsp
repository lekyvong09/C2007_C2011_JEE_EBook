<div class="container">
	<div class="d-flex justify-content-between align-items-center">
		<a href="<c:url value="/admin/" />">
			<img alt="logo" src="<c:url value="/images/logo.png" />">
		</a>
		
		<c:if test="${sessionScope.userEmail != null}" >
			<div class="d-flex justify-content-end vw-50">
				Welcome, <c:out value="${sessionScope.userEmail}" />
				<span class="mx-3"> | </span>
				<a href="<c:url value="/admin/login" />" type="button" class="btn btn-outline-secondary ms-4">Logout</a>
			</div>
		</c:if>
		
		<c:if test="${sessionScope.userEmail == null}" >
			<div class="d-flex justify-content-end vw-50">
				<a href="<c:url value="/admin/login.jsp" />" type="button" class="btn btn-outline-secondary ms-4">Login</a>
			</div>
		</c:if>
		
	</div>
	
	<div class="d-flex justify-content-center">
		<a href="manage_user" class="fw-bold">Users</a>
		<span class="mx-3"> | </span>
		<a href="manage_category?command=LIST" class="fw-bold">Categories</a>
		<span class="mx-3"> | </span>
		<a href="#" class="fw-bold">Books</a>
		<span class="mx-3"> | </span>
		<a href="#" class="fw-bold">Customers</a>
		<span class="mx-3"> | </span>
		<a href="#" class="fw-bold">Orders</a>
	</div>
</div>

	