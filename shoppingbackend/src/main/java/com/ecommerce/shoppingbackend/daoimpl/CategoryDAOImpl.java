package com.ecommerce.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.shoppingbackend.dao.CategoryDAO;
import com.ecommerce.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	//using HQL to get the list of all categories
	@Override
	public List<Category> list() {
		
		String selectActiveCategory="FROM Category WHERE active = :active";
		
		Query query= sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active",true);
		
		return query.getResultList();
	}

	// getting single category based on id from database
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;

		}catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
	
	//for updating a single category
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		}catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	//we are not deleting the category just updatin the status of isActive to false
	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;

		}catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	
	

}