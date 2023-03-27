package org.user.mgmt.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.user.mgmt.model.User;
import org.user.mgmt.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User insert(User userVO) {
		return this.userRepository.save(userVO);
	}

	@Override
	public List<User> findAll() {

		return this.userRepository.findAll();
	}

	@Override
	public void delete(int id) {
		this.userRepository.deleteById(id);
	}

	@Override
	public User findById(int id) {
		return this.userRepository.findById(id).get();
	}

	@Override
	public User updateUser(int id, User userVO) {
		userVO.setId(id);
		return this.userRepository.save(userVO);
	}

}
