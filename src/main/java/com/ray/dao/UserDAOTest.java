package com.ray.dao;

import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.Test;

import com.ray.entity.User;

public class UserDAOTest {
	
	

	@Test
	public void testGetTotalRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateUser() {
		UserDAO userDAO = new UserDAO();
		
		User newUser = new User("test@email.com", "test", "password");
		User insertedUser = userDAO.create(newUser);
		
		assertTrue(insertedUser.getUserId() > 0);
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByIdObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByIdUser() {
		UserDAO userDAO = new UserDAO();
		userDAO.deleteById(2);
		
		assertTrue(Objects.isNull(userDAO.getById(2)));
	}

}
