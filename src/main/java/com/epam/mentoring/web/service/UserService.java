package com.epam.mentoring.web.service;

import java.util.Collection;

import com.epam.mentoring.web.model.User;

public interface UserService {

	User getUserById(Long id);

	Collection<User> getAllUsers();

	void deleteUser(Long id);

	Long createUser(User user);

	void updateUser(Long id, User user);

}
