package com.epam.mentoring.task2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceConsumers {
	
	public void startTwoConsumersAgainstTwoResources() throws InterruptedException {
		final Lock resourceA = new ReentrantLock();
		final Lock resourceB = new ReentrantLock();
		final CountDownLatch startLatch = new CountDownLatch(1);
		final CountDownLatch finishLatch = new CountDownLatch(2);

		Runnable resourceConsumer1 = () -> {
			try {
				startLatch.await();
				resourceA.lock();
				System.out.println("Consumer 1 is using resource A.");
				resourceB.lock();
				System.out.println("Consumer 1 is using resource B.");
				
				resourceB.unlock();
				System.out.println("Consumer 1 completed with resource B.");
				resourceA.unlock();
				System.out.println("Consumer 1 completed with resource A.");

				finishLatch.countDown();
			} catch (InterruptedException e) { }
		};

		Runnable resourceConsumer2 = () -> {
			try {
				startLatch.await();
				resourceB.lock();
				System.out.println("Consumer 2 is using resource B.");
				resourceA.lock();
				System.out.println("Consumer 2 is using resource A.");
				
				resourceA.unlock();
				System.out.println("Consumer 2 completed with resource A.");
				resourceB.unlock();
				System.out.println("Consumer 2 completed with resource B.");
				
				finishLatch.countDown();
			} catch (InterruptedException e) { }
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(resourceConsumer1);
		executor.submit(resourceConsumer2);
		
		startLatch.countDown();
		finishLatch.await();
		
		System.out.println("Consumer executions are completed.");
	}
	
	public void startFastAndSlowConsumersAgainstOneResource() throws InterruptedException {
		final Lock resource = new ReentrantLock(true);
		Runnable fastConsumer = () -> {
			try {
				while (true) {
					resource.lock();
					System.out.println(System.currentTimeMillis() + " fast consumer is using resource.");
					Thread.sleep(100);
					resource.unlock();
					System.out.println(System.currentTimeMillis() + " fast consumer completed with resource.");
				}
			} catch (InterruptedException e) { }
		};
		Runnable slowConsumer = () -> {
			try {
				while (true) {
					Thread.sleep(1000);
					resource.lock();
					System.out.println(System.currentTimeMillis() + " slow consumer is using resource.");
					Thread.sleep(1000);
					resource.unlock();
					System.out.println(System.currentTimeMillis() + " slow consumer completed with resource.");
				}
			} catch (InterruptedException e) { }
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		executor.submit(fastConsumer);
		executor.submit(fastConsumer);
		executor.submit(fastConsumer);
		executor.submit(slowConsumer);
		
		Thread.sleep(15000);
	}
	
}
