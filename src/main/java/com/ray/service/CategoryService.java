package com.ray.service;

import java.util.List;

import com.ray.dao.CategoryDAO;
import com.ray.entity.Category;

public class CategoryService {
	private CategoryDAO categoryDAO;
	
	public CategoryService() {
		categoryDAO = new CategoryDAO();
	}
	
	
	public List<Category> listCategory() {
		return categoryDAO.getListAll();
	}
	
	public Category getById(Integer categoryId) {
		return categoryDAO.getById(categoryId);
	}
	
	public void delete(Integer categoryId) {
		categoryDAO.deleteById(categoryId);
	}
	
	
	public String create(Category category) {
		Category existCategory = categoryDAO.getByName(category.getName());
		
		if (existCategory != null) {
			return "The category name already exists";
		}
		
		categoryDAO.create(category);
		return null;
	}
	
	
	public String update(Category category) {
		Category existCategory = categoryDAO.getByNameAndNotCategoryId(category);
		
		if (existCategory != null) {
			return "The category name already exists";
		}
		
		categoryDAO.update(category);
		return null;
	}
}
