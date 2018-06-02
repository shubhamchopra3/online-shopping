package com.ecommerce.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.shoppingbackend.dao.ProductDAO;
import com.ecommerce.shoppingbackend.dto.Category;
import com.ecommerce.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int id) {

		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() {

		Query query = sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class);
		return query.getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {

		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		//1st active is the column name while second active is the parameter name
		String selectActiveProducts = "FROM Product WHERE active = :active";

		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts,Product.class)
				.setParameter("active",true)
				.getResultList();

		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		//1st active is the column name while second active is the parameter name
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId=:categoryId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active",true)
				.setParameter("categoryId",categoryId)  //this paraemter is set by the value passed to the function
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String getLatestActiveProducts = "FROM Product WHERE active = :active ORDER BY id";
		return sessionFactory.getCurrentSession()
				.createQuery(getLatestActiveProducts,Product.class)
				.setParameter("active",true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
		
	}

}
