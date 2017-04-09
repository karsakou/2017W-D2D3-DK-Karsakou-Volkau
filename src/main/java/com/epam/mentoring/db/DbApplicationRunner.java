package com.epam.mentoring.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.epam.mentoring.db.repository.UsersRepository;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DbApplicationRunner {
    
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(DbApplicationRunner.class, args);
		UsersRepository repository = ctx.getBean(UsersRepository.class);
		System.out.println(repository.getAllUsers());
		ctx.close();
	}
	
}
