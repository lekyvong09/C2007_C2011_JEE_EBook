package com.ray.dao;

import java.util.List;

import com.ray.entity.Category;

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


	
}
