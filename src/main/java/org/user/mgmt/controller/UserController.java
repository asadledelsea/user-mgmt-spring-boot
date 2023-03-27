package org.user.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.user.mgmt.model.User;
import org.user.mgmt.service.UserService;

@RestController
@RequestMapping(value = "user")
@CrossOrigin(origins = {"http://elasticbeanstalk-us-east-1-101705381076.s3-website-us-east-1.amazonaws.com:5000",
		  				"http://elasticbeanstalk-us-east-1-101705381076.s3-website-us-east-1.amazonaws.com"})
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public User registerUser(@RequestBody User userVO) {

		return this.userService.insert(userVO);
	}

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<User> findAllUser() {

		return this.userService.findAll();
	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public User findById(@PathVariable int id) {
		return this.userService.findById(id);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public User updateUser(@PathVariable int id, @RequestBody User userVO) {

		return this.userService.updateUser(id, userVO);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable int id) {

		this.userService.delete(id);
	}
	
	@GetMapping(value = "/list")
	@ResponseStatus(value = HttpStatus.OK)
	public List<User> getUsers() {
		return this.userService.findAll();
	}
}
