package com.event.source;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.event.source.handler.Handler;
import com.event.source.model.Event;

public final class EventSource {

	private static volatile EventSource eventSourceInstance = new EventSource();

	private EventSource() {
	}

	private Map<Class<? extends Event>, List<Handler<? extends Event>>> eventMap;

	{
		this.eventMap = new ConcurrentHashMap<>();
	}

	public void subscribe(Class<? extends Event> event, Handler<? extends Event> handler) {
		List<Handler<? extends Event>> handlerList = this.eventMap.containsKey(event)
				? this.eventMap.get(event.getClass())
				: new ArrayList<>();

		handlerList.add(handler);
		this.eventMap.put(event, handlerList);
	}

	public <T extends Event> void publish(T event) {
		if (this.eventMap.containsKey(event.getClass())) {
			for (Handler<? extends Event> handler : this.eventMap.get(event.getClass())) {
				((Handler<T>) handler).fired(event);
			}
		}
	}

	public synchronized static EventSource getInstance() {
		return eventSourceInstance;
	}
}