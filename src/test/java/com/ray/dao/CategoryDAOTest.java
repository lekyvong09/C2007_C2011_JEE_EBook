package com.ray.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ray.entity.Category;

class CategoryDAOTest {
	private static CategoryDAO categoryDAO;
	@BeforeAll
	public static void setup() {
		categoryDAO = new CategoryDAO();
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTotalRecord() {
		fail("Not yet implemented");
	}

	@Test
	void testCreateCategory() {
		Category newCategory = new Category("Comic");
		Category insertedCategory = categoryDAO.create(newCategory);
		assertTrue(insertedCategory.getCategoryId() > 0);
	}

	@Test
	void testUpdateCategory() {
		Category updateCategory = new Category(1, "Romantic");
		
		Category expectCategory = categoryDAO.getById(updateCategory.getCategoryId());
		
		expectCategory.setName("Romantic");
		
		Category updatedCategory = categoryDAO.update(updateCategory);
		assertEquals(expectCategory, updatedCategory);
	}
	

	@Test
	void testGetByIdObject() {
		fail("Not yet implemented");
	}

	@Test
	void testGetListAll() {
		List<Category> categoryList = categoryDAO.getListAll();
		System.out.println(categoryList);
		assertTrue(categoryList.size() > 0);
	}

}
