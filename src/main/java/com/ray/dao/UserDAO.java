package com.ray.dao;

import java.util.List;

import com.ray.entity.User;

public class UserDAO extends JpaDAO<User> {
	public UserDAO() {
		super(User.class);
	}

	@Override
	public User create(User object) {
		return super.create(object);
	}

	@Override
	public User update(User object) {
		return super.update(object);
	}

	@Override
	public User get(Object objectId) {
		return super.get(objectId);
	}

	@Override
	public List<User> getListAll() {
		return super.getListAll();
	}

	@Override
	public void delete(User object) {
		super.delete(object);
	}
	
	
}
