package com.fork.join.tryer.trigger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;

import org.springframework.stereotype.Component;

import com.fork.join.tryer.task.CustomRecursiveAction;
import com.fork.join.tryer.util.PoolUtil;

@Component
public class Trigger {

	private static final String text = "adwddddddddddddddddddddddddddddddddddddddawda"
			+ "dwddddddddddddddddddddddddddddddddddddd"
			+ "dawdadwddddddddddddddddddddddddddddddddddddddawdadwdddddd"
			+ "ddddddddddddddddddddddddddddddddawd";

	public void start() {
		RecursiveAction recursiveAction = new CustomRecursiveAction(text, 0);
		PoolUtil.forkJoinPool.execute(recursiveAction);
		System.out.println("finish");

//		try {
//			Future<String> result = this.calculateAsync();
//			System.out.println(result.get());
//			System.out.println("start");
//		} catch (InterruptedException | ExecutionException e) {
//			e.printStackTrace();
//		}
	}

	public Future<String> calculateAsync() throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(2000);
			completableFuture.complete("Hello");
			return null;
		});

		return completableFuture;
	}
}
