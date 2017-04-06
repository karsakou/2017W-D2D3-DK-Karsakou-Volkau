package com.epam.mentoring.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.google.common.base.Strings;

public class FilesystemClassLoader extends ClassLoader {
	
	private final ClassLoader parentClassLoader;
	
	private final String rootPath;

	public FilesystemClassLoader(ClassLoader parentClassLoader, String rootPath) {
		this.parentClassLoader = parentClassLoader;
		this.rootPath = rootPath;
	}

	private Class<?> loadClassOutsideClasspath(String className) throws FileNotFoundException, IOException {
		File classFile = Strings.isNullOrEmpty(rootPath)
				? new File(className.replace(".", File.pathSeparator) + ".class")
				: new File(rootPath, className.replace(".", File.pathSeparator) + ".class");

		try (InputStream classInputStream = new FileInputStream(classFile)) {
			
			byte[] classData = IOUtils.toByteArray(classInputStream);
			Class<?> clazz = defineClass(null, classData, 0, classData.length);
			resolveClass(clazz);
			return clazz;
		}
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		if (name.toLowerCase().contains("custom")) {
			try {
				return loadClassOutsideClasspath(name);
			} catch (IOException e) {
				e.printStackTrace();
				return parentClassLoader.loadClass(name);
			}
		}
		return parentClassLoader.loadClass(name);
	}
	
}
