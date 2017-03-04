package com.epam.mentoring;

import org.testng.annotations.Test;

import com.epam.mentoring.task2.ResourceConsumers;

public class ResourceConsumersTest {

	private final ResourceConsumers consumers = new ResourceConsumers();
	
	@Test
	public void deadLock() throws InterruptedException {
		consumers.startTwoConsumersAgainstTwoResources();
	}
	
	@Test
	public void slowConsumer() throws InterruptedException {
		consumers.startFastAndSlowConsumersAgainstOneResource();
	}
	
}
