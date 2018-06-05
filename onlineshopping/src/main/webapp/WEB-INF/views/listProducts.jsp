<div class="container">

	<div class="row">

		<!-- would be used to display sidebar -->
		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>

		</div>

		<!-- To display the actual products -->
		<div class="col-md-9">

			<!--  Add bootstrap breadcrumb component -->
			<div class="row">

				<div class="col-lg-12">


					<c:if test="${UserClickAllProducts == true}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>

						</ol>
					</c:if>

					<c:if test="${UserClickCategoryProducts==true}">
						<script>
							
						window.categoryId = '${category.id}';  //this is window global object available in javascript , this is done so we can use this in myapp.js when we have to create a post url based on category user has clicked
						
						</script>

						<ol class="breadcrumb">  <!-- Breadcrumb bootstrap class  -->

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
							<!-- This is coming from PageController showCategoryProducts function category is passed -->

						</ol>
					</c:if>

				</div>

			</div>

			<!-- Data Table Jquery -->
			<div class="row">

				<div class="col-xs-12" id="productDisplay">



					<table id="productListTable"
						class="table table-striped table-bordered">

						<thead>

							<tr>
								<th>name</th>
								<th>brand</th>
								<th>Price</th>
								<th>Qty. Available</th>
								

								</tr>


						</thead>
						
						
						
						
						<tbody>

						</tbody>



					</table>

				</div>


			</div>


		</div>



	</div>




</div>