package com.epam.mentoring.oop.decorator;

public class SimplePersonInputStream implements PersonInputStream {

	private final Person person;
	
	public SimplePersonInputStream(Person person) {
		this.person = person;
	}

	@Override
	public Person readPerson() {
		return person;
	}
	
}
