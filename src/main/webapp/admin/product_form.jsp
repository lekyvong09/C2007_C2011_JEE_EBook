<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- CSS -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
	<!-- Bootstrap theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
</head>
<body>
	<%@include file="navigation.jsp" %>
	
	<c:if test="${message != null }" >
		<input id="notification" type="hidden" value="${message }">
	</c:if>
	
	
	<div class="container py-5">
		<c:choose>
			<c:when test="${ theProduct != null && not empty theProduct.productId }">
				<c:url var="actionLink" value="manage_product">
					<c:param name="command" value="UPDATE" />
				</c:url>
				<h1 class="text-center mb-4">Update product</h1>
			</c:when>
			
			<c:otherwise>
				<c:url var="actionLink" value="manage_product">
					<c:param name="command" value="INSERT" />
				</c:url>
				<h1 class="text-center mb-4">Create new product</h1>
			</c:otherwise>
		</c:choose>
		
		<hr class="mx-auto" style="width:50%;">
		
		<div class="d-flex flex-column align-items-center py-5">
			<form id="productForm" action="${ actionLink}" method="post" style="width:350px;">
				<c:if test="${theProduct != null}">
					<input type="hidden" name="productId" value="${theProduct.productId}">
				</c:if>
				
				<div class="form-floating mb-3">
				  <input name="name" type="text" value="${ theProduct.name }"
				  		class="form-control" id="inputProductName" placeholder="inputProductName">
				  <label for="inputProductName">Title</label>
				  <div class="invalid-feedback">Please input a title</div>
				</div>
				
				<div class="form-floating mb-3">
				  <input name=author type="text" value="${ theProduct.author }"
				  		class="form-control" id="inputAuthor" placeholder="inputAuthor">
				  <label for="inputAuthor">Author</label>
				  <div class="invalid-feedback">Please input a author</div>
				</div>
				
				<div class="form-floating mb-3">
				  <input name="isbn" type="text" value="${ theProduct.isbn }"
				  		class="form-control" id="inputisbn" placeholder="inputisbn">
				  <label for="inputisbn">ISBN</label>
				  <div class="invalid-feedback">Please input ISBN</div>
				</div>
				
				<div class="form-floating mb-3">
				  <input name="publishDate" type="date" value="${ theProduct.publishDate }"
				  		class="form-control" id="publishDate" placeholder="publishDate">
				  <label for="publishDate">Publish date</label>
				  <div class="invalid-feedback">Please input publish date</div>
				</div>
				
				<div class="mb-3">
				  <input name="image" type="file" class="form-control" >
				  <div class="invalid-feedback">Please choose a file image</div>
				</div>
				
				<div class="form-floating mb-3">
				  <input name="price" type="text" value="${ theProduct.price }"
				  		class="form-control" id="price" placeholder="price">
				  <label for="price">Price</label>
				  <div class="invalid-feedback">Please input price</div>
				</div>
				
				<div class="form-floating mb-3">
				  <textarea name="description" class="form-control" id="description" style="height: 100px;"
				  		placeholder="description">${ theProduct.description }</textarea>
				  <label for="description">Description</label>
				  <div class="invalid-feedback">Please input Description</div>
				</div>
				
				<div class="d-flex justify-content-center">
					<button type="submit" class="btn btn-primary mt-4 w-50">Submit</button>
				</div>
			</form>
		</div>
		
	</div>

	
<%@include file="footer.jsp" %>
<!-- JavaScript -->
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	
<script type="text/javascript">
	var notification = document.getElementById("notification");
	
	if (notification != null && notification.value.length > 0) {
		alertify.error(notification.value);
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#productForm").validate({
			rules: {
				name: {required: true },
			},
			errorPlacement: function(error, element) {},
			highlight: function (element, errorClass, validClass) {
				$(element).addClass("is-invalid").removeClass("is-valid");
			},
			unhighlight: function (element, errorClass, validClass) {
				$(element).addClass("is-valid").removeClass("is-invalid");
			},
		});
	});
</script>

</body>
</html>