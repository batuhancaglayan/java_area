package com.redis.cluster.client;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import io.lettuce.core.LettuceFutures;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

public class App {
	public static void main(String[] args) {
		try {

			RedisURI redisUri = RedisURI.Builder.redis("10.100.129.151").withPort(7000).build();
			RedisClusterClient clusterClient = RedisClusterClient.create(redisUri);

			StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
			RedisAdvancedClusterAsyncCommands<String, String> commands = connection.async();

			// disable auto-flushing
			commands.setAutoFlushCommands(false);

			// perform a series of independent calls
			List<RedisFuture<?>> futures = new ArrayList<RedisFuture<?>>();
			for (int i = 0; i < 5; i++) {
				futures.add(commands.set("key-" + i, "value-" + i));
				futures.add(commands.expire("key-" + i, 3600));
			}

			// write all commands to the transport layer
			commands.flushCommands();

			// synchronization example: Wait until all futures complete
			boolean result = LettuceFutures.awaitAll(5, TimeUnit.SECONDS,
					futures.toArray(new RedisFuture[futures.size()]));

			// later
			connection.close();

			// withPassword("authentication")
			// 10.100.129.151

//			try {
//				boolean result = LettuceFutures.awaitAll(200, TimeUnit.SECONDS,
//						futureList.toArray(new RedisFuture[futureList.size()]));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

//			StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
//			
//			RedisAdvancedClusterAsyncCommands asyncCommands = connection.async();
//			asyncCommands.setex("deneme1", 30, "deneme1");
////
//			asyncCommands.lpush("tasks1", "firstTask1");
//			asyncCommands.lpush("tasks1", "secondTask1");
//			RedisFuture<String> redisFuture = asyncCommands.lpop("tasks1");
			// String nextTask = redisFuture.get();
			// System.out.println(nextTask);
			// String a = value1.
			// System.out.println(a);
//			boolean result = LettuceFutures.awaitAll(20, TimeUnit.SECONDS,
//					futureList.toArray(new RedisFuture[futureList.size()]));
//			

			// value1.forEach(item -> System.out.println(item));

//			RedisAdvancedClusterCommands<String, String> syncCommands = connection.sync();
//
////			String key = UUID.randomUUID().toString();
////			String result = syncCommands.set(key, "batuhan");
////			System.out.println(result);
////
////			String oldValue = syncCommands.get(key);
////			System.out.println(oldValue);
//			List<String> value1 = syncCommands.keys("*key*");
//			value1.forEach(item -> System.out.println(item));
//			System.out.println(value1);
//			String value2 = syncCommands.get("b");
//			System.out.println(value2);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

//	public static List<RedisFuture<?>> executeCommandsForEventData(List<ExtendedEventObject> resultData) {
//		RedisClusterAsyncCommands<String, String> commands = connection.async();
//
//		// disable auto-flushing
//		commands.setAutoFlushCommands(false);
//		List<RedisFuture<?>> futures = new ArrayList<>();
//
//		AtomicInteger maxSize = new AtomicInteger(0);
//
//		resultData.forEach(extendedEvent -> {
//			String serializedKey = extendedEvent.getSerializedKey();
//
//			for (EventData data : extendedEvent.getEventList()) {
//				try {
//					String dataValue = this.serializer.serialize(data);
//
//					if (maxSize.get() == this.config.listPartitionSizeForCacheLoader) {
//						commands.flushCommands();
//						maxSize.set(0);
//					}
//
//					futures.add(commands.lpush(serializedKey, dataValue));
//					futures.add(commands.expire(serializedKey, config.redisExpireTime));
//					maxSize.addAndGet(2);
//				} catch (Exception e) {
//					log.error(
//							"Event data write error occured on REDIS with key " + serializedKey + " Exception = " + e);
//				}
//			}
//
//			if (extendedEvent.getRelationFieldsHashMap().isEmpty()) {
//				return;
//			}
//
//			if (maxSize.get() == this.config.listPartitionSizeForCacheLoader) {
//				commands.flushCommands();
//				maxSize.set(0);
//			}
//
//			futures.add(commands.hmset(extendedEvent.getRelationFieldHash(), extendedEvent.getRelationFieldsHashMap()));
//			futures.add(commands.expire(extendedEvent.getRelationFieldHash(), config.redisExpireTime));
//			maxSize.addAndGet(2);
//		});
//
//		commands.flushCommands();
//
//		return futures;
//	}
}
