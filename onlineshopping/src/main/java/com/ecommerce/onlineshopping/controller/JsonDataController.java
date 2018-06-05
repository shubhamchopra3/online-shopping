package com.ecommerce.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.shoppingbackend.dao.ProductDAO;
import com.ecommerce.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("/all/products") //url becomes http://localhost:8080/onlineshopping/json/data/all/products
	@ResponseBody  //this annotation is responsible for conversion of object to json
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
	}

	@RequestMapping(value="/category/{id}/products")  //url becomes http://localhost:8080/onlineshopping/json/data/category/1/products
	@ResponseBody  //this annotation is responsible for conversion of object to json
	public List<Product> getProductsByCategory(@PathVariable("id") int id){
		
		return productDAO.listActiveProductsByCategory(id);
	}

	
	
}
