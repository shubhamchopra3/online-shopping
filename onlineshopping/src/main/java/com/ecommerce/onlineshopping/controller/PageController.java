package com.ecommerce.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.shoppingbackend.dao.CategoryDAO;
import com.ecommerce.shoppingbackend.daoimpl.CategoryDAOImpl;
import com.ecommerce.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("UserClickHome",true);
		return mv;
	}
	@RequestMapping(value ="/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("UserClickAbout",true);
		return mv;
	}
	@RequestMapping(value ="/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("UserClickContact",true);
		return mv;
	}
	
	//Methods to load all the products and based on category
	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("UserClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//CategoryDAO to fetch a single category 
		Category category=null;
		category=categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing the single category object
		mv.addObject("category",category);
	
		mv.addObject("UserClickCategoryProducts",true);
		return mv;
	}
}
