package com.in.memory.cache.tryer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in.memory.cache.tryer.google.cache.LoadingCacheTryer;

@SpringBootApplication
public class InMemoryCacheTryerApplication implements CommandLineRunner {

	@Autowired
	private LoadingCacheTryer loadingCacheTryer;

	public static void main(String[] args) {
		SpringApplication.run(InMemoryCacheTryerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> result1 = loadingCacheTryer.get(1);
		
		List<String> result2 = loadingCacheTryer.get(0);
		Thread.currentThread().sleep(10);
		
		List<String> result3 = loadingCacheTryer.get(0);
		System.out.println("finish");
	}
}
