package com.ray.service;

import java.util.List;

import com.ray.dao.ProductDAO;
import com.ray.entity.Product;

public class ProductService {
	private ProductDAO productDAO;
	
	public ProductService() {
		productDAO = new ProductDAO();
	}
	
	
	public List<Product> listProduct() {
		return productDAO.getListAll();
	}
	
	public Product getById(Integer productId) {
		return productDAO.getById(productId);
	}
	
	public void delete(Integer productId) {
		productDAO.deleteById(productId);
	}
	
	
	public String create(Product product) {
		Product existProduct = productDAO.getByName(product.getName());
		
		if (existProduct != null) {
			return "The product name already exists";
		}
		
		productDAO.create(product);
		return null;
	}
	
	
	public String update(Product product) {
		Product existProduct = productDAO.getByNameAndNotProductId(product);
		
		if (existProduct != null) {
			return "The product name already exists";
		}
		
		productDAO.update(product);
		return null;
	}
	
	
	public List<Product> searchProductByName(String name) {
		return productDAO.getProductsByName(name);
	}
}
