package com.epam.mentoring;

import org.testng.annotations.Test;

import com.epam.mentoring.task2.SharedInMemoryResourceConsumers;

public class ResourceConsumersTest {

	private final SharedInMemoryResourceConsumers consumers = new SharedInMemoryResourceConsumers();
	
	@Test
	public void deadLock() throws InterruptedException {
		consumers.startTwoConsumersAgainstTwoResources();
	}
	
	@Test
	public void slowConsumer() throws InterruptedException {
		consumers.startFastAndSlowConsumersAgainstOneResource();
	}
	
}
