<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="list-group">

	<c:forEach items="${categories}" var="category">  <!-- ${categories} is passed from page controller to page.jsp below dynamic url is created when user click on category corresponding url is created based on id   -->
		<a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item" id="category123">${category.name}</a>
	</c:forEach>


</div>