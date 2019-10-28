package com.spring.multithread.tryer.worker;

import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.multithread.tryer.model.DenemeItem;
import com.spring.multithread.tryer.util.SomeProcess;

public class DenemeCallable implements Callable<Void> {

	@Autowired
	private SomeProcess someProcess;

	private List<DenemeItem> denemeItemList;

	public DenemeCallable(List<DenemeItem> denemeItemList) {
		this.denemeItemList = denemeItemList;
	}

	@Override
	public Void call() throws Exception {
		this.someProcess.doProcess(this.denemeItemList);
		Thread.currentThread().sleep(2000);
		return null;
	}
}
