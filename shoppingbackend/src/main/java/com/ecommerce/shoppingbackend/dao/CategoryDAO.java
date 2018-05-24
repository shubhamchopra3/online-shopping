package com.ecommerce.shoppingbackend.dao;

import java.util.List;

import com.ecommerce.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category get(int id);
	

}
