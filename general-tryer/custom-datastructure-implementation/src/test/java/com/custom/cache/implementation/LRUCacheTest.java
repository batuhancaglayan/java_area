package com.custom.cache.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Iterator;

import org.junit.Test;

import com.custom.datastructure.cache.implementation.lru.LRUWithBuiltIn;

public class LRUCacheTest {

	@Test
	public void lruWithBuiltIn() {
		LRUWithBuiltIn<Integer, Integer> cache = new LRUWithBuiltIn<>(4);
		cache.set(1, 11);
		cache.set(2, 22);
		cache.set(3, 33);
		cache.set(4, 44);
		cache.set(5, 55);
		assertNull(cache.get(1));
		assertEquals(22, cache.get(2).intValue());
	}
}
