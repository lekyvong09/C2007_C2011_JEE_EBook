<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
	<%@include file="navigation.jsp" %>
	
	<div class="container py-5">
		<h1 class="text-center mb-4">Category Management</h1>
		<hr class="mx-auto" style="width:50%;">
		
		<h2 class="text-center">Quick action</h2>
		<div class="d-flex justify-content-center">
			<a href="manage_category?command=NEW" class="me-4">New Category</a>
		</div>
		<hr class="mx-auto" style="width:50%;">
		
		<div class="table-responsive py-3">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Index</th>
						<th>ID</th>
						<th>Category Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${categoryList}" var="category" varStatus="count">
						<!-- http://localhost:8080/ebook/admin/manage_category?command=LOAD&userId=categoryId -->
						<c:url var="updateLink" value="manage_category">
							<c:param name="command" value="LOAD"/>
							<c:param name="categoryId" value="${category.categoryId}"/>
						</c:url>
						
						<tr>
							<td>${count.index + 1}</td>
							<td>${category.categoryId }</td>
							<td>${category.name }</td>
							<td>
								<a href="${updateLink}">Edit</a>
								<span class="mx-3"> | </span>
								<a href="manage_category?command=DELETE&categoryId=${category.categoryId}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
		
		
	</div>
	
<%@include file="footer.jsp" %>

</body>
</html>