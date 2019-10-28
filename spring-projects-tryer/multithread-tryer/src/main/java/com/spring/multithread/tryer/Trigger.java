package com.spring.multithread.tryer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.multithread.tryer.model.DenemeItem;
import com.spring.multithread.tryer.util.CollectionDivider;
import com.spring.multithread.tryer.worker.DenemeCallable;

@Component
public class Trigger {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	//@Autowired
	//private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	//private ExecutorServiceAdapter adapter;

	private CollectionDivider<DenemeItem> collectionDivider;
	
	@Autowired
	private ExecutorService executorService;

	@PostConstruct
	private void init() {
		//this.adapter = new ExecutorServiceAdapter(this.threadPoolTaskExecutor);
		this.collectionDivider = new CollectionDivider<>();
	}

	public void run() throws InterruptedException, ExecutionException {
		while (true) {
			List<List<DenemeItem>> denemeItemListList = this.collectionDivider.divide(this.getDenemeItemList(), 10000);
			List<DenemeCallable> tasks = new ArrayList<>();
			for (List<DenemeItem> item : denemeItemListList) {
				tasks.add(this.applicationContext.getBean(DenemeCallable.class, item));
			}

			List<Future<Void>> results = this.executorService.invokeAll(tasks);
					//this.adapter.invokeAll(tasks);
			for (Future<Void> result : results) {
				result.get();
			}
			
			System.out.println("loop complete");
		}
	}

	private List<DenemeItem> getDenemeItemList() {
		List<DenemeItem> denemeItemList = new ArrayList<>();
		for (int i = 0; i < 450000; i++) {
			denemeItemList.add(new DenemeItem());
		}

		return denemeItemList;
	}
}
