package com.design.pattern.observer.pattern.event.source;

import java.util.ArrayList;
import java.util.List;

import com.design.pattern.observer.pattern.event.Observer;

public class EventSource {

	private List<Observer> observerList;
	
	{
		this.observerList = new ArrayList<>();
	}
	
	public void addObserver(Observer observer) {
		this.observerList.add(observer);
	}
	
	public void notifyObservers(String message) {
		this.observerList.forEach(x->{
			x.send(message);
		});
	}
}
