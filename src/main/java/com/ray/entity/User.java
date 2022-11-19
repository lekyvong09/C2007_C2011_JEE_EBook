package com.ray.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="User.HQL.findByEmail", query = "SELECT u FROM User u where u.email = :email"),
	@NamedQuery(name="User.HQL.getUserById", query = "SELECT u FROM User u where u.userId = :userId"),
	@NamedQuery(name="User.HQL.findByEmailAndNotUserId", query = "SELECT u FROM User u where u.email = :email and u.userId != :userId"),
	@NamedQuery(name="User.HQL.checkLogin", 
		query = "SELECT u FROM User u where u.email = :email and u.password = :password")
})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="password")
	private String password;
	
	/// var user = new User();
	public User() {
	}
	
	/// var user = new User(user@email.com, Bob, password)
	public User(String email, String fullName, String password) {
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	
	public User(Integer userId, String email, String fullName, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", fullName=" + fullName + ", password=" + password
				+ "]";
	}
	
	
}
