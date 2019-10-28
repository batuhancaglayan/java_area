package com.custom.cache.implementation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Before;

import com.custom.datastructure.cache.implementation.expire.Cache;
import com.custom.datastructure.cache.implementation.expire.CustomExpireCache;
import com.custom.datastructure.cache.implementation.lru.LRUCustom;
import com.custom.datastructure.cache.implementation.lru.LRUWithDeque;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private Cache cache;

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	@Override
	protected void setUp() {
		this.cache = new CustomExpireCache();
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws InterruptedException
	 */
	@org.junit.Test
	public void testExpireCache() throws InterruptedException {
//		this.cache.add("1", "aq", 1000000);
//		Object result = this.cache.get("1");
//		assertThat(result, notNullValue());
//		assertThat(result.toString(), equalTo("aq"));
//		Thread.currentThread();
//		Thread.sleep(1000);
//
//		Object result1 = this.cache.get("1");
//		assertThat(result1, nullValue());
		// assertEquals(this.cache.get("1"), "");
		// assertThat().isEqualTo("aq");
		// assertTrue( true );
	}
	
	@org.junit.Test
	public void testLRUDeque(){
		LRUWithDeque lruCache = new LRUWithDeque(4);
		lruCache.put(1, "1");
		lruCache.put(2, "2");
		lruCache.put(3, "3");
		lruCache.put(1, "1");
		lruCache.put(4, "4");
		lruCache.put(5, "5");
		lruCache.display();
	}
	
	@org.junit.Test
	public void testLRUNode(){
		LRUCustom lruCache = new LRUCustom(4);
		lruCache.put(1, "1");
		lruCache.put(2, "2");
		lruCache.put(3, "3");
		lruCache.put(1, "1");
		lruCache.put(4, "4");
		lruCache.put(5, "5");
		lruCache.display();
	}
}
