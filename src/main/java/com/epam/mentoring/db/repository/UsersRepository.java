package com.epam.mentoring.db.repository;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.epam.mentoring.db.api.Repository;
import com.epam.mentoring.db.api.RsColumnMapper;
import com.epam.mentoring.db.api.RsColumnMappers;
import com.epam.mentoring.db.api.Select;
import com.epam.mentoring.db.model.User;

@Repository
@Component
public class UsersRepository {

	@RsColumnMappers(value = {
		@RsColumnMapper(columnName = "id", propertyName = "id"),
		@RsColumnMapper(columnName = "firstName", propertyName = "firstName"),
		@RsColumnMapper(columnName = "lastName", propertyName = "lastName")
	}, modelType = User.class)
	@Select(value = "select * from mentoring.users")
	public Collection<User> getAllUsers() {
		return null;
	};
}
