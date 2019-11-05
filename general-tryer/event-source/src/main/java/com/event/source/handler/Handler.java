package com.event.source.handler;

import com.event.source.model.Event;

public interface Handler<T extends Event> {

	void fired(T event);
}
