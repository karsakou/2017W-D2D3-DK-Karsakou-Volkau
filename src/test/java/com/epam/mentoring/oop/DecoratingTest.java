package com.epam.mentoring.oop;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

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
		assertEquals(is.readPerson().getPersonName(), "simplePerson");
		
		is = new DecoratedPersonInputStream(new SimplePersonInputStream(() -> "simplePerson"));
		assertEquals(is.readPerson().getPersonName(), "simplePerson");
	}
	
	@Test
	public void decoratingPersonOutputStreamCapitalizesPersonName() {
		PersonOutputStream os = new DecoratingPersonOutputStream(new SimplePersonOutputStream(
				person -> assertEquals(person.getPersonName(), "SimplePerson")));
		os.writePerson(() -> "SimplePerson");
		
		os = new DecoratingPersonOutputStream(new SimplePersonOutputStream(
				person -> assertEquals(person.getPersonName(), "SimplePerson")));
		os.writePerson(() -> "simplePerson");
	}
	
}
