package com.ray.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ray.entity.Product;

public class ProductDAO extends JpaDAO<Product> {
	public ProductDAO() {
		super(Product.class);
	}

	@Override
	public Product create(Product object) {
		return super.create(object);
	}

	@Override
	public Product update(Product object) {
		return super.update(object);
	}

	@Override
	public Product getById(Object objectId) {
		return super.getById(objectId);
	}

	@Override
	public List<Product> getListAll() {
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


	public Product getByName(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		
		List<Product> productList = super.getNamedEqueryWithParams("Product.HQL.getByName", params);
		
		/// get first record
		if (productList != null && productList.size() > 0) {
			return productList.get(0);
		}
		
		return null;
	}
	
	
	public Product getByNameAndNotProductId(Product product) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", product.getName());
		params.put("productId", product.getProductId());
		
		List<Product> productList = super.getNamedEqueryWithParams("Product.HQL.getByNameAndNotProductId", params);
		
		/// get first record
		if (productList != null && productList.size() > 0) {
			return productList.get(0);
		}
		
		return null;
	}
	
	public List<Product> getProductsByName(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		
		List<Product> productList = super.getNamedEqueryWithParams("Product.HQL.getByName", params);
		
		return productList;
	}
}
