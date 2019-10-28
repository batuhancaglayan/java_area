package com.spring.hystrix.tryer.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Component
@Scope("prototype")
public class DenemeCache {

	private final LoadingCache<String, List<String>> loadingCache;

	public DenemeCache() {
		this.loadingCache = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS)
				.build(new CacheLoader<String, List<String>>() {
					@Override
					public List<String> load(String id) throws Exception {
						List<String> ccc = new ArrayList<>();
						ccc.add("a");
						ccc.add("b");
						System.out.println("load");
						return ccc;
					}
				});
	}

	public List<String> get(String id) {
		List<String> processes = new ArrayList<>();
		try {
			processes.addAll(loadingCache.get(id));
		} catch (Exception e) {
		}
		return processes;
	}
}
