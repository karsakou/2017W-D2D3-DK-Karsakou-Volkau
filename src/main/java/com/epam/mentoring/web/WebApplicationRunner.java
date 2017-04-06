package com.epam.mentoring.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplicationRunner {
	
	public static void main(String[] args) {
		System.setProperty("multipart.max-file-size", "100MB");
		System.setProperty("multipart.max-request-size", "100MB");
		SpringApplication.run(WebApplicationRunner.class, args);
	}
	
}
