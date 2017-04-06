package com.epam.mentoring.web.service;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.epam.mentoring.web.model.User;

@Service
public class InMemoryUserService implements UserService {

	private final ConcurrentMap<Long, User> users = new ConcurrentHashMap<>();
	
	private final Random random = new Random();
	
	@Override
	public User getUserById(Long id) {
		return users.compute(id, (key, value) -> {
			if (value == null) {
				throw new RuntimeException("User with id - " + key + " doesn't exist.");
			}
			return value;
		});
	}

	@Override
	public Collection<User> getAllUsers() {
		return users.values();
	}

	@Override
	public void deleteUser(Long id) {
		users.compute(id, (key, value) -> {
			if (value == null) {
				throw new RuntimeException("User with id - " + key + " doesn't exist.");
			}
			return null;
		});
	}

	@Override
	public Long createUser(User user) {
		Long uuid = random.nextLong();
		users.compute(uuid, (key, value) -> {
			if (value != null) {
				throw new RuntimeException("User with id - " + key + " already exists.");
			}
			user.setId(key);
			return user;
		});
		return uuid;
	}

	@Override
	public void updateUser(Long id, User user) {
		users.compute(id, (key, value) -> {
			if (value == null) {
				throw new RuntimeException("User with id - " + key + " doesn't exist.");
			}
			return user;
		});
	}
}
