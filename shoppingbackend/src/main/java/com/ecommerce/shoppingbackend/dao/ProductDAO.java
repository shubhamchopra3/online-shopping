package com.ecommerce.shoppingbackend.dao;

import java.util.List;

import com.ecommerce.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int id);
	List<Product> list();
	boolean add(Product product);
	boolean delete(Product product);
	boolean update(Product product);

	//bussiness methods
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
	
	
}
