package com.ray.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.entity.Category;
import com.ray.entity.User;

public class CategoryDAO extends JpaDAO<Category> {
	public CategoryDAO() {
		super(Category.class);
	}

	@Override
	public Category create(Category object) {
		return super.create(object);
	}

	@Override
	public Category update(Category object) {
		return super.update(object);
	}

	@Override
	public Category getById(Object objectId) {
		return super.getById(objectId);
	}

	@Override
	public List<Category> getListAll() {
		return super.getListAll();
	}

	@Override
	public void deleteById(Object objectId) {
		super.deleteById(objectId);
	}

	@Override
	public long getTotalRecord() {
		return super.getTotalRecord();
	}


	public Category getByName(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		
		List<Category> categoryList = super.getNamedEqueryWithParams("Category.HQL.getByName", params);
		
		/// get first record
		if (categoryList != null && categoryList.size() > 0) {
			return categoryList.get(0);
		}
		
		return null;
	}
	
	
	public Category getByNameAndNotCategoryId(Category category) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", category.getName());
		params.put("categoryId", category.getCategoryId());
		
		List<Category> categoryList = super.getNamedEqueryWithParams("Category.HQL.getByNameAndNotCategoryId", params);
		
		/// get first record
		if (categoryList != null && categoryList.size() > 0) {
			return categoryList.get(0);
		}
		
		return null;
	}
}
