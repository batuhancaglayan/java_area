package com.event.source.subscriber;

import com.event.source.EventSource;
import com.event.source.handler.Handler;
import com.event.source.model.SimpleEvent;

public class EventSubscriber {

	private EventSource eventSource;

	private Handler<SimpleEvent> handler;

	{
		this.eventSource = EventSource.getInstance();
		this.handler = event -> {
			this.handlerFunction(event);
		};
		this.eventSource.subscribe(SimpleEvent.class, handler);
	}

	private void handlerFunction(SimpleEvent event) {
		System.out.println(event.getName());
	}
}
