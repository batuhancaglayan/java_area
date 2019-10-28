package com.thread.interrupt.tryer.model;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorkerModel<T> {

	Future<T> taskFucture;
	
	Runnable taskInstance;
}
