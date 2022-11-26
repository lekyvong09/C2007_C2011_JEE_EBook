<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
			<form id="productForm" action="${ actionLink}" method="post" style="width:350px;"
				enctype="multipart/form-data">
				
				<c:if test="${theProduct != null}">
					<input type="hidden" name="productId" value="${theProduct.productId}">
					<input type="hidden" id="theSelectedCategory" value="${theProduct.category.name}"/>
				</c:if>
				
				<div class="form-floating mb-3">
					<select name="category" class="form-select" id="selectCategory">
						<option value="" selected>Select a category</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.categoryId }">${category.name }</option>
						</c:forEach>
					</select>
					<label for="selectCategory">Category</label>
				</div>
				
				<div class="form-floating mb-3">
				  <input name="name" type="text" value="${ theProduct.name }"
				  		class="form-control" id="inputProductName" placeholder="inputProductName">
				  <label for="inputProductName">Title</label>
				  <div class="invalid-feedback">Please input a title</div>
				</div>
				
				<div class="form-floating mb-3">
				  <input name="author" type="text" value="${ theProduct.author }"
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
				  <input name="publishDate" type="date" 
				  		value='<fmt:formatDate pattern="yyyy-MM-dd" value="${ theProduct.publishDate }" />'
				  		class="form-control" id="publishDate" placeholder="publishDate">
				  <label for="publishDate">Publish date</label>
				  <div class="invalid-feedback">Please input publish date</div>
				</div>
				
				<div class="mb-3">
				  <input name="image" type="file" onchange="loadFile(event)" class="form-control" >
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
				
				<c:choose>
					<c:when test="${ theProduct != null && not empty theProduct.productId }">
						<img id="preview-image-before-upload" src="data:image/jpg;base64, ${theProduct.base64Image}" 
							style="width: 240px; object-fit:cover;"/>
					</c:when>
					
					<c:otherwise>
						<img id="preview-image-before-upload" style="width: 240px; object-fit:cover;"/>
					</c:otherwise>
				</c:choose>
		
				
				
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
	var theSelectedCategory = document.getElementById("theSelectedCategory");
	console.log(theSelectedCategory.value);
	if (theSelectedCategory != null && theSelectedCategory.value.length > 0) {
		var fieldProductCategory = document.getElementById("selectCategory");
		var options = Array.from(fieldProductCategory.options);
		var optionToSelect = options.find(item => item.text === theSelectedCategory.value);
		optionToSelect.selected = true;
	}
	
</script>

<script type="text/javascript">
	function loadFile(event) {
		if (event.target.files.length > 0) {
			var previewImage = document.getElementById('preview-image-before-upload');
			previewImage.src = URL.createObjectURL(event.target.files[0]);
		}
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#productForm").validate({
			rules: {
				name: {required: true },
				category: {required: true },
				author: {required: true },
				description: {required: true },
				isbn: {required: true },
				image: {required: true },
				publishDate: {required: true },
				price: {required: true, number: true },
				description: {required: true },
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