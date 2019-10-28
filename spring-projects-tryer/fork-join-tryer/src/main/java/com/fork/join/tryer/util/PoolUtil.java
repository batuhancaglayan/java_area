package com.fork.join.tryer.util;

import java.util.concurrent.ForkJoinPool;

public class PoolUtil {
	
	public static ForkJoinPool forkJoinPool =  new ForkJoinPool(6); //ForkJoinPool.commonPool();
}
