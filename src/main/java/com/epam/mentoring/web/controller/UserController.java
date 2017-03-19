package com.epam.mentoring.web.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.mentoring.web.model.User;
import com.epam.mentoring.web.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final String JSON_MEDIA_TYPE = "application/json;charset=UTF-8";
	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(path = "/{id}", produces = JSON_MEDIA_TYPE)
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping(produces = JSON_MEDIA_TYPE)
	public Collection<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping(consumes = JSON_MEDIA_TYPE)
	public Long createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping(path = "/{id}", consumes = JSON_MEDIA_TYPE)
	public void updateUser(@PathVariable Long id, @RequestBody User user) {
		userService.updateUser(id, user);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
}
