package com.epam.mentoring.oop;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.epam.mentoring.oop.decorator.DecoratedPersonInputStream;
import com.epam.mentoring.oop.decorator.DecoratingPersonOutputStream;
import com.epam.mentoring.oop.decorator.PersonInputStream;
import com.epam.mentoring.oop.decorator.PersonOutputStream;
import com.epam.mentoring.oop.decorator.SimplePersonInputStream;
import com.epam.mentoring.oop.decorator.SimplePersonOutputStream;

public class DecoratingTest {

	@Test
	public void decoratingPersonInputStreamUncapitalizesPersonName() {
		PersonInputStream is = new DecoratedPersonInputStream(new SimplePersonInputStream(() -> "SimplePerson"));
		assertThat(is.readPerson().getPersonName()).isEqualTo("simplePerson");
		
		is = new DecoratedPersonInputStream(new SimplePersonInputStream(() -> "simplePerson"));
		assertThat(is.readPerson().getPersonName()).isEqualTo("simplePerson");
	}
	
	@Test
	public void decoratingPersonOutputStreamCapitalizesPersonName() {
		PersonOutputStream os = new DecoratingPersonOutputStream(new SimplePersonOutputStream(
				person -> assertThat(person.getPersonName()).isEqualTo("SimplePerson")));
		os.writePerson(() -> "SimplePerson");
		
		os = new DecoratingPersonOutputStream(new SimplePersonOutputStream(
				person -> assertThat(person.getPersonName()).isEqualTo("SimplePerson")));
		os.writePerson(() -> "simplePerson");
	}
	
}
