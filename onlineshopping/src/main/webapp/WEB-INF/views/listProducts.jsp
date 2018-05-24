<div class="container">

	<div class="row">

		<!-- would be used to display sidebar -->
		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>

		</div>

		<!-- To display the actual products -->
		<div class="col-md-9">

			<div class="row">

				<div class="col-lg-12">

					<!--  Add bootstrap breadcrumb component -->
					<c:if test="${UserClickAllProducts == true}">
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${UserClickCategoryProducts==true}">
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>

				</div>

			</div>


		</div>



	</div>




</div>