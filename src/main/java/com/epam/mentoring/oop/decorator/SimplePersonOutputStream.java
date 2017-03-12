package com.epam.mentoring.oop.decorator;

import java.util.function.Consumer;

public class SimplePersonOutputStream implements PersonOutputStream {

	private final Consumer<Person> personConsumer;
	
	public SimplePersonOutputStream(Consumer<Person> personConsumer) {
		this.personConsumer = personConsumer;
	}

	@Override
	public void writePerson(Person person) {
		personConsumer.accept(person);
	}

}
