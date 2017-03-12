package com.epam.mentoring.oop.adapter;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

public class ListAdapterTest {

	
	
	@Test
	public void onPopLastElementIsPopedOut() {
		CustomList<String> customList = new ListAdapter<>();
		
		assertEquals(customList.size(), 0);
		customList.push("el1");
		
		assertEquals(customList.pop(), "el1");
		assertEquals(customList.size(), 0);
	}
	
}
