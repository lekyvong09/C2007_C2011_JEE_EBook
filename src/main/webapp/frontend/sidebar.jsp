<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<div class="d-flex flex-column p-3 float-start h-100" style="width:280px;">	
	<ul class="nav nav-pills mb-auto flex-column">
		<c:forEach items="${categoryList}" var="category" varStatus="status">
		
			<li class="nav-item mb-3">
				
				<a href="#" class="nav-link d-flex align-items-center link-dark">
					<c:choose>
						<c:when test="${fn:toLowerCase(category.name) == 'comic' }">
							<img class="me-2" src="<c:url value="/images/comic.svg" />" style="width:50px; height: 50px;"/>
						</c:when>
						<c:when test="${fn:toLowerCase(category.name) == 'programming' }">
							<img class="me-2" src="<c:url value="/images/programming.svg" />" style="width:50px; height: 50px;"/>
						</c:when>
						<c:when test="${fn:toLowerCase(category.name) == 'romantic' }">
							<img class="me-2" src="<c:url value="/images/romantic.svg" />" style="width:50px; height: 50px;"/>
						</c:when>
						<c:when test="${fn:toLowerCase(category.name) == 'fiction' }">
							<img class="me-2" src="<c:url value="/images/fiction.svg" />" style="width:50px; height: 50px;"/>
						</c:when>
						<c:otherwise>
							<img class="me-2" src="<c:url value="/images/book.svg" />" style="width:50px; height: 50px;"/>
						</c:otherwise>		
					</c:choose>
					
					<c:out value="${category.name }" />
				</a>
				
			</li>
			
			<c:if test="${status.last }">
				<hr>
			</c:if>
		
		</c:forEach>
		
		
	</ul>

</div>