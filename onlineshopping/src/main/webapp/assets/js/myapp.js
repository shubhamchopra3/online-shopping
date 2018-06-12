  /*var products =[
	    {
	        "id": 1,
	        "code": "PRDABC123DEFX",
	        "name": "iPhone 5s",
	        "brand": "apple",
	        "unitPrice": 18000,
	        "quantity": 5,
	        "purchases": 0,
	        "views": 0
	    },
	    {
	        "id": 2,
	        "code": "PRDDEF123DEFX",
	        "name": "Samsung s7",
	        "brand": "samsung",
	        "unitPrice": 32000,
	        "quantity": 2,
	        "purchases": 0,
	        "views": 0
	    },
	    {
	        "id": 3,
	        "code": "PRDPQR123WGTX",
	        "name": "Google Pixel",
	        "brand": "google",
	        "unitPrice": 57000,
	        "quantity": 5,
	        "purchases": 0,
	        "views": 0
	    },
	    {
	        "id": 4,
	        "code": "PRDMNO123PQRX",
	        "name": " Macbook Pro",
	        "brand": "apple",
	        "unitPrice": 54000,
	        "quantity": 3,
	        "purchases": 0,
	        "views": 0
	    },
	    {
	        "id": 5,
	        "code": "PRDABCXYZDEFX",
	        "name": "Dell Latitude E6510",
	        "brand": "dell",
	        "unitPrice": 48000,
	        "quantity": 5,
	        "purchases": 0,
	        "views": 0
	    }
];*/

  //for card view coded  by sanet
  /*var $productDisplay = $('#productDisplay');
  var str='';
  for (var i=0;i<products.length;i++){
	  str+=`
	  <div class="col-sm-3">
		  <img src="https://image-cdn.styfi.in/cache/catalog/products/5a6a64b149ab5249de822b8f_1524042080355_0-376x470.jpg" width=200px;height:300px>
		  <div class="col-sm-12" style="padding-left: 25px;">
			  <p>Name: ${products[i].name}</p>
			  <p>Quantity: ${products[i].quantity}</p>
		  </div>
	  </div>`
	  
	  
  }
  $productDisplay.html(str);*/
  
 //dataTable code 

  var $table = $('#productListTable');
  
  if($table.length) {  //so that this code runs when table is there ie only when view products button is clicked
	
	  var jsonUrl='';
	  if(window.categoryId==''){  //this means user has not clicked on any special category and wants to see all products
		  jsonUrl=window.contextRoot+'/json/data/all/products';
		  
	  }else{
		 
		  console.log(window.categoryId);
		  jsonUrl=window.contextRoot+'/json/data/category/'+ window.categoryId +'/products';  //id from line no 76
		  
	  }
	  
	 
	  
	  $table.DataTable( {   //this is predefined function in datatable jquery plugin
		  
		  pageLength:5,  //how many rows per page
		  ajax:{
			  
			  url :jsonUrl,
			  dataSrc : ''
		 },
		 columns : [
			  
			 
			 
			 		{data:'name'
			 		},
			 		{data:'brand'
			 		},
			 		{data:'unitPrice',
			 			mRender: function(data,type,row){  //mRender function is of jquery datatable
			 				return '&#8377; '+ data    //&#8377; is html entity code for ruppes symbol
			 			}
			 		},
			 		{data:'quantity'
			 		},
			 		{
			 			data:'id',
			 			bSortable:false, //as we do not want to sort this view product and add to cart product column
			 			mRender: function(data,type,row){
			 				var str='';
			 					str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160; '  //url to view the product data contains the product id, &#160; is html code for space , for giving space between tow url
			 					str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>'  //url to add the product to the cart
			 				return str;
			 				
			 			}	
			 		}
		 ]
	  }
	  
	  
	  );
	  
	  
	  
  }
  
  
