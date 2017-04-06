package com.epam.mentoring;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;

import org.junit.Test;

import com.epam.mentoring.task3.FilesystemClassLoader;

public class FilesystemClassLoaderTest {

	private final FilesystemClassLoader classLoader = new FilesystemClassLoader(
		FilesystemClassLoaderTest.class.getClassLoader(), ""
	);
	
	@Test
	public void loadCustomClass() throws ClassNotFoundException {
		Class<?> customClass = classLoader.loadClass("CustomCircle");
		assertThat(customClass).isNotNull();
		for(Method method : customClass.getMethods()) {
			System.out.println(method);
		}
	}
	
	@Test
	public void loadUsualClass() throws ClassNotFoundException {
		Class<?> clazz = classLoader.loadClass("com.epam.mentoring.task1.Circle");
		assertThat(clazz).isNotNull();
		for(Method method : clazz.getMethods()) {
			System.out.println(method);
		}
	}
	
}
