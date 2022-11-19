package com.ray.dao;

import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ray.dao.UserDAO;
import com.ray.entity.User;

public class UserDAOTest {
	private static UserDAO userDAO;
	
	@BeforeAll
	public static void setup() {
		userDAO = new UserDAO();
	}

	@Test
	public void testGetTotalRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateUser() {
		User newUser = new User("test223@email.com", "test223", "password");
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
		userDAO.deleteById(10);
		
		assertTrue(Objects.isNull(userDAO.getById(10)));
	}
	
	@Test
	public void testGetUserByEmail() {
		User user = userDAO.getUserByEmail("ray@email.com");
		System.out.println(user);
		assertNotNull(user);
	}

	@Test
	public void testLoginSuccess() {
		assertTrue(userDAO.checkLogin("ray@email.com", "password"));
	}
}
