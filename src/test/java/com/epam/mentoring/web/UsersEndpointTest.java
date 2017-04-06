package com.epam.mentoring.web;


import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.mentoring.web.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UsersEndpointTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void createAndGet() {
		User user = new User();
		user.setLastname("testLastName");
		user.setLogin("testLogin");
		user.setPassword("testPassword");
		user.setUsername("testUsername");
		
		Long userId = restTemplate.postForObject("http://localhost:8080/users", user, Long.class);
		assertThat(userId).isNotNull();
		
		assertThat(restTemplate.getForObject("http://localhost:8080/users/{id}", User.class, userId)).isEqualTo(user);
	}
	
	@Test
	public void postStream() {
		RequestEntity<byte[]> bytes = RequestEntity.post(URI.create("http://localhost:8080/users/icons")).body("Test icon body".getBytes());
		assertThat(restTemplate.exchange(bytes, String.class).getBody()).isEqualTo("Test icon body");
	}
	
}
