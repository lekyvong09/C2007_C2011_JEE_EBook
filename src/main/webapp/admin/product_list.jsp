<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
	<%@include file="navigation.jsp" %>
	
	<div class="container py-5">
		<h1 class="text-center mb-4">Product Management</h1>
		<hr class="mx-auto" style="width:50%;">
		
		<h2 class="text-center">Quick action</h2>
		<div class="d-flex justify-content-center">
			<a href="manage_product?command=NEW" class="me-4">New Product</a>
		</div>
		<hr class="mx-auto" style="width:50%;">
		
		<div class="table-responsive py-3">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Index</th>
						<th>ID</th>
						<th>Image</th>
						<th>Title</th>
						<th>Author</th>
						<th>Category</th>
						<th>Price</th>
						<th>Last Updated</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${productList}" var="product" varStatus="count">
						<c:url var="updateLink" value="manage_product">
							<c:param name="command" value="LOAD"/>
							<c:param name="productId" value="${product.productId}"/>
						</c:url>
						
						<tr>
							<td>${count.index + 1}</td>
							<td>${product.productId }</td>
							<td>
								<img src="data:image/jpg;base64, ${product.base64Image}" style="width: 130px; height: 180px; object-fit:cover;">
							</td>
							<td>${product.name }</td>
							<td>${product.author }</td>
							<td>${product.category.name }</td>
							<td>${product.price }</td>
							<td>${product.lastUpdateTime }</td>
							<td>
								<a href="${updateLink}">Edit</a>
								<span class="mx-3"> | </span>
								<a href="manage_product?command=DELETE&productId=${product.productId}">Delete</a>
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