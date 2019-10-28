package com.in.memory.cache.tryer.google.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Component
public class LoadingCacheTryer {

	private LoadingCache<Integer, List<String>> loadingCache;

	@PostConstruct
	private void init() {
		this.loadingCache = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS)
				.build(new CacheLoader<Integer, List<String>>() {
					@Override
					public List<String> load(Integer key) throws Exception {
						try {

							System.out.println("load");
							if (key == 0) {
								throw new Exception("key 0 error");
							}

							List<String> ccc = new ArrayList<>();
							ccc.add("a");
							ccc.add("b");
			
							return ccc;
						} catch (Exception e) {
							System.err.println(e.getMessage());
							return new ArrayList<>();
						}
					}
				});
	}

	public List<String> get(Integer key) {
		try {
			return this.loadingCache.get(key);
		} catch (ExecutionException e) {
			System.err.println(e.getMessage());
			return new ArrayList<>();
		}
	}
}
