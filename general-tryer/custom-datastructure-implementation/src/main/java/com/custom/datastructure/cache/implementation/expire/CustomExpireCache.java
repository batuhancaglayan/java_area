package com.custom.datastructure.cache.implementation.expire;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CustomExpireCache implements Cache {

	private final int CLEAN_UP_PERIOD_IN_SEC = 5;

	private final Map<String, SoftReference<CacheObject>> cache = new ConcurrentHashMap<>();

	public CustomExpireCache() {

		Thread cleanerThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(CLEAN_UP_PERIOD_IN_SEC * 1000);
					for (Entry<String, SoftReference<CacheObject>> item : cache.entrySet()) {
						if (item.getValue().get().isExpired()) {
							cache.remove(item.getKey());
						}
					}
//					cache.entrySet().removeIf(entry -> Optional.ofNullable(entry.getValue()).map(SoftReference::get)
//							.map(CacheObject::isExpired).orElse(false));
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		cleanerThread.setDaemon(true);
		cleanerThread.start();
	}

	public void add(String key, Object value, long periodInMillis) {
		if (key == null) {
			return;
		}

		if (value == null) {
			this.remove(key);
		}

		long expiryTime = System.currentTimeMillis() + periodInMillis;
		this.cache.put(key, new SoftReference<>(new CacheObject(value, expiryTime)));
	}

	public void remove(String key) {
		this.cache.remove(key);
	}

	public Object get(String key) {
		
		SoftReference<CacheObject> cacheObject = this.cache.get(key);
		if (cacheObject == null) {
			return null;
		}
		
		return !cacheObject.get().isExpired() ? cacheObject.get().value : null;
		
//		return Optional.ofNullable(cache.get(key)).map(SoftReference::get)
//				.filter(cacheObject -> !cacheObject.isExpired()).map(CacheObject::getValue).orElse(null);
	}

	public void clear() {
		this.cache.clear();
	}

	public long size() {
		return this.cache.entrySet().stream().filter(entry -> Optional.ofNullable(entry.getValue())
				.map(SoftReference::get).map(cacheObject -> !cacheObject.isExpired()).orElse(false)).count();
	}

	@AllArgsConstructor
	private static class CacheObject {

		@Getter
		private Object value;
		private long expiryTime;

		boolean isExpired() {
			return System.currentTimeMillis() > expiryTime;
		}
	}

}
