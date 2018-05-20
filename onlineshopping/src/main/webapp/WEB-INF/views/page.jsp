<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="images" value="/resources/images" />
<spring:url var="js" value="/resources/js" />
<spring:url var="css" value="/resources/css" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping -${title}</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Self coded css -->
   <link rel="stylesheet" type="text/css" href="${css}/myapp.css">
   
   <!-- Bootstrap theme css from bootswatch.com -->
   <link rel="stylesheet" type="text/css" href="${css}/bootstrap-theme.css">

<style>
</style>



</head>
<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">
			<!-- Load this section only when user clicks home -->
			<c:if test="${UserClickHome == true}">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load this section only when user clicks About -->
			<c:if test="${UserClickAbout == true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load this section only when user clicks home -->
			<c:if test="${UserClickContact == true}">
				<%@include file="contact.jsp"%>
			</c:if>

		</div>

		<!-- Footer -->

		<%@include file="./shared/footer.jsp"%>


		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>
	</div>
</body>
</html>
