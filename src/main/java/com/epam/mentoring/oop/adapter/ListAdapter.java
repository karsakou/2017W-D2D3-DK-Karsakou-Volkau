package com.epam.mentoring.oop.adapter;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter<E> implements CustomList<E> {

	private final List<E> casualList;
	
	public ListAdapter() {
		this.casualList = new ArrayList<>();
	}

	@Override
	public E pop() {
		return casualList.remove(casualList.size() - 1);
	}

	@Override
	public void push(E element) {
		casualList.add(element);
	}
	
	@Override
	public int size() {
		return casualList.size();
	}
}
