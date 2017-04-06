package com.epam.mentoring.oop.adapter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ListAdapterTest {
	
	@Test
	public void onPopLastElementIsPopedOut() {
		CustomList<String> customList = new ListAdapter<>();
		
		assertThat(customList.size()).isEqualTo(0);
		customList.push("el1");
		
		assertThat(customList.pop()).isEqualTo("el1");
		assertThat(customList.size()).isEqualTo(0);
	}
	
}
