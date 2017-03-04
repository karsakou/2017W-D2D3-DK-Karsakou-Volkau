package com.epam.mentoring.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;

public class MemoryConsumer {

	private final String filename;
	
	public MemoryConsumer(String filename) {
		this.filename = filename;
	}

	public void readFileWithMemoryLeaks() {
		try (InputStream fileInput = new ClassPathResource(filename).getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileInput))) {
			
			Collection<String> lines = new ArrayList<>();
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			
			lines.stream().map(l -> l.substring(0, 3)).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFileWithoutMemoryLeaks() {
		try (InputStream fileInput = new ClassPathResource(filename).getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(fileInput))) {

			Collection<String> result = new ArrayList<>();
			String line;
			while ((line = reader.readLine()) != null) {
				result.add(line.substring(0, 3));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
