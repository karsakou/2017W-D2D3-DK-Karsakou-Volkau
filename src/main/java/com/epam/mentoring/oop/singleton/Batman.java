package com.epam.mentoring.oop.singleton;

import java.util.UUID;

/**
 * Since there is only one Batman in the world history.
 * @author Raman_Volkau
 *
 */
public final class Batman {

	private static final Object monitor = new Object();
	
	private static Batman instance;
	
	private final String id;
	
	private Batman() {
		this.id = UUID.randomUUID().toString();
	}
	
	public static Batman instance() {
		if (instance == null) {
			synchronized (monitor) {
				if (instance == null) {
					instance = new Batman();
				}
			}
		}
		return instance;
	}

	public String getId() {
		return id;
	}
	
}
