<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="list-group">

	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="category123">${category.name}</a>
	</c:forEach>


</div>