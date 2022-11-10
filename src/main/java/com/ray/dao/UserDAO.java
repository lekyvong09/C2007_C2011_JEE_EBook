package com.ray.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public User getById(Object objectId) {
		return super.getById(objectId);
	}

	@Override
	public List<User> getListAll() {
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


	public User getUserByEmail(String email) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		
		List<User> userList =super.getNamedEqueryWithParams("User.HQL.findByEmail", params);
		
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		
		return null;
	}
	
	
	public User getUserByUserId(Integer userId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		
		List<User> userList =super.getNamedEqueryWithParams("User.HQL.getUserById", params);
		
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		
		return null;
	}
	
	
	public User getUserByEmailAndNotUserId(User user) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", user.getEmail());
		params.put("userId", user.getUserId());
		
		List<User> userList =super.getNamedEqueryWithParams("User.HQL.findByEmailAndNotUserId", params);
		
		if (userList != null && userList.size() > 0) {
			return userList.get(0);
		}
		
		return null;
	}
}
