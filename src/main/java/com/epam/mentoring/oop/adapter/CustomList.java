package com.epam.mentoring.oop.adapter;

public interface CustomList<E> {

	E pop();
	
	void push(E element);
	
	int size();
	
}
