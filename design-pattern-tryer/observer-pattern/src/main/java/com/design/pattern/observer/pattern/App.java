package com.design.pattern.observer.pattern;

import com.design.pattern.observer.pattern.event.Observer;
import com.design.pattern.observer.pattern.event.source.EventSource;

public class App {
	public static void main(String[] args) {

		EventSource eventSource = new EventSource();
		Observer observer1 = message -> {
			System.out.println("observer1 => " + message);
		};

		Observer observer2 = message -> {
			System.out.println("observer2 => " + message);
		};

		eventSource.addObserver(observer1);
		eventSource.addObserver(observer2);
		eventSource.notifyObservers("deneme");
	}
}
