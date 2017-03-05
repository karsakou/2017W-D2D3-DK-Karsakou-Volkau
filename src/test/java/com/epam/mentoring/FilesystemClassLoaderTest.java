package com.epam.mentoring;

import static org.testng.Assert.assertNotNull;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.epam.mentoring.task3.FilesystemClassLoader;

public class FilesystemClassLoaderTest {

	private final FilesystemClassLoader classLoader = new FilesystemClassLoader(
		FilesystemClassLoaderTest.class.getClassLoader(), ""
	);
	
	@Test
	public void loadCustomClass() throws ClassNotFoundException {
		Class<?> customClass = classLoader.loadClass("CustomCircle");
		assertNotNull(customClass);
		for(Method method : customClass.getMethods()) {
			System.out.println(method);
		}
	}
	
	@Test
	public void loadUsualClass() throws ClassNotFoundException {
		Class<?> clazz = classLoader.loadClass("com.epam.mentoring.task1.Circle");
		assertNotNull(clazz);
		for(Method method : clazz.getMethods()) {
			System.out.println(method);
		}
	}
	
}
