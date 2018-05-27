package com.ecommerce.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.shoppingbackend.dao.CategoryDAO;
import com.ecommerce.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();
		category.setId(1);
		category.setDescription("Television description");
		category.setImageUrl("/img");
		category.setName("Television");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setDescription("Mobile description");
		category.setImageUrl("/img");
		category.setName("Mobile");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setDescription("Laptop description");
		category.setImageUrl("/img");
		category.setName("Laptop");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		for (Category category1 : categories) {
			if (category1.getId() == id) {
				return category1;
			}

		}

		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			
			sessionFactory.getCurrentSession().persist(category);
			
			
			return true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			return true;
		}
		
		
		
		
	}

}
