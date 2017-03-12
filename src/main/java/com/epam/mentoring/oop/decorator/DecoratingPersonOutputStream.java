package com.epam.mentoring.oop.decorator;

import org.springframework.util.StringUtils;

public class DecoratingPersonOutputStream implements PersonOutputStream {

	private final PersonOutputStream delegate;
	
	public DecoratingPersonOutputStream(PersonOutputStream delegate) {
		this.delegate = delegate;
	}

	@Override
	public void writePerson(Person person) {
		if (Character.isUpperCase(person.getPersonName().charAt(0))) {
			delegate.writePerson(person);
			return;
		}
		delegate.writePerson(() -> StringUtils.capitalize(person.getPersonName()));
	}

}
