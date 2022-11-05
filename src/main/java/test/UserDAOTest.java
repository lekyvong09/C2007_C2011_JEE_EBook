package test;

import static org.junit.Assert.*;

import java.util.Objects;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ray.dao.UserDAO;
import com.ray.entity.User;

public class UserDAOTest {
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setup() {
		userDAO = new UserDAO();
	}

	@Test
	public void testGetTotalRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateUser() {
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
		userDAO.deleteById(2);
		
		assertTrue(Objects.isNull(userDAO.getById(2)));
	}
	
	@Test
	public void testGetUserByEmail() {
		User user = userDAO.getUserByEmail("ray@email.com");
		System.out.println(user);
		//assertNotNull(user);
	}

}
