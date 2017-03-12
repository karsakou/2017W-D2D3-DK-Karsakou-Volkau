package com.epam.mentoring.oop.decorator;

import org.springframework.util.StringUtils;

public class DecoratedPersonInputStream implements PersonInputStream {

	private final PersonInputStream delegate;

	public DecoratedPersonInputStream(PersonInputStream delegate) {
		this.delegate = delegate;
	}

	@Override
	public Person readPerson() {
		Person person = delegate.readPerson();
		if (Character.isLowerCase(person.getPersonName().charAt(0))) {
			return person;
		}
		return () -> StringUtils.uncapitalize(person.getPersonName());
	}

}
