package org.user.mgmt.service;

import java.util.List;

import org.user.mgmt.model.User;

public interface UserService {
	public User insert(User userVO);

	public List<User> findAll();

	public void delete(int id);

	public User findById(int id);

	public User updateUser(int id, User userVO);

}
