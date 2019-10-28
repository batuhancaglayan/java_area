package com.immutable.thread.share.tryer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.immutable.thread.share.tryer.worker.DenemeWorker;

@SpringBootApplication
public class ImmutableThreadShareApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ImmutableThreadShareApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String value = "batuhan";
		DenemeWorker worker1 = new DenemeWorker(value, 3000);
		DenemeWorker worker2 = new DenemeWorker(value, 5000);

		worker1.start();
		worker2.start();

		while (true) {
			Thread.currentThread();
			Thread.sleep(7000);
			System.out.println(Thread.currentThread().getName() + " => " + value);
		}
	}
}
