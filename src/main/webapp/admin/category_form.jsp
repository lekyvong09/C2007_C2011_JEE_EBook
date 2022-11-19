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
			<c:when test="${ theCategory != null && not empty theCategory.categoryId }">
				<c:url var="actionLink" value="manage_category">
					<c:param name="command" value="UPDATE" />
				</c:url>
				<h1 class="text-center mb-4">Update category</h1>
			</c:when>
			
			<c:otherwise>
				<c:url var="actionLink" value="manage_category">
					<c:param name="command" value="INSERT" />
				</c:url>
				<h1 class="text-center mb-4">Create new category</h1>
			</c:otherwise>
		</c:choose>
		
		<hr class="mx-auto" style="width:50%;">
		
		<div class="d-flex flex-column align-items-center py-5">
			<form id="categoryForm" action="${ actionLink}" method="post" style="width:350px;">
				<c:if test="${theCategory != null}">
					<input type="hidden" name="categoryId" value="${theCategory.categoryId}">
				</c:if>
				
				
				<div class="form-floating mb-3">
				  <input name="name" type="text" value="${ theCategory.name }"
				  		class="form-control" id="inputCategoryName" placeholder="inputCategoryName">
				  <label for="inputCategoryName">Category Name</label>
				  <div class="invalid-feedback">Please input a name</div>
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
		$("#categoryForm").validate({
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