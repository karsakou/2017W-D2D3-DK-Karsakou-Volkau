package com.epam.mentoring.oop.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class BatmanTest {

	@Test
	public void oneBatmanInMultithreadeEnv() throws InterruptedException {
		int threadCount = 4;
		CountDownLatch startLatch = new CountDownLatch(1);
		CountDownLatch finishLatch = new CountDownLatch(threadCount);
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		
		Collection<String> batmanIds = new CopyOnWriteArrayList<>();
		
		Runnable job = () -> {
			try {
				startLatch.await();
			} catch (InterruptedException e) {
			}
			IntStream.range(0, 5).boxed().map(i -> Batman.instance().getId()).forEach(id -> batmanIds.add(id));
			finishLatch.countDown();
		};
		
		IntStream.range(0, threadCount).forEach(i -> executor.submit(job));
		
		startLatch.countDown();
		finishLatch.await();
		
		assertThat(batmanIds.stream().collect(Collectors.toSet()).size()).isEqualTo(1);
	}
	
}
