package com.custom.cache.implementation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.custom.datastructure.multikeymap.CustomMultiKeyMap;

public class CustomMultiKeyMapTest {

	private CustomMultiKeyMap<Integer, Integer, String> store;

	@Before
	public void init() {
		this.store = new CustomMultiKeyMap<>();
	}

	@Test
	public void test() {
		Integer key1 = 22;
		Integer key2 = 33;
		String input = key1 + "" + key2;
		this.store.put(22, 33, input);
		String output = this.store.get(22, 33);

		assertThat(input, equalTo(output));

		List<String> values = this.store.getK1ValueList(key1);
	}
}
