package com.design.pattern.observer.pattern.event;

@FunctionalInterface
public interface Observer {

	void send(String message);
}
