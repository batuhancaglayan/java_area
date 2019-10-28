package com.fork.join.tryer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fork.join.tryer.trigger.Trigger;
import com.fork.join.tryer.util.PoolUtil;

@SpringBootApplication
public class ForkJoinTryerApplication implements CommandLineRunner {

	@Autowired
	private Trigger trigger;

	public static void main(String[] args) {
		SpringApplication.run(ForkJoinTryerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		boolean gate = true;
		while (true) {
			if (gate) {
				this.trigger.start();
				gate = false;
			}

			if (PoolUtil.forkJoinPool.getRunningThreadCount() == 0) {
				System.err.println(PoolUtil.forkJoinPool.getParallelism());
				break;
			}
		}

		System.out.println("exit");
	}
}
