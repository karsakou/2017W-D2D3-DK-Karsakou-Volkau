package com.epam.mentoring;


import org.junit.Test;

import com.epam.mentoring.task2.MemoryConsumer;

public class MemoryConsumerTest {

	@Test
	public void withMemoryLeaks() {
		MemoryConsumer consumer = new MemoryConsumer("Task #5 - Data.txt");
		consumer.readFileWithMemoryLeaks();
	}
	
	@Test
	public void withoutMemoryLeaks() {
		MemoryConsumer consumer = new MemoryConsumer("Task #5 - Data.txt");
		consumer.readFileWithoutMemoryLeaks();
	}
}
