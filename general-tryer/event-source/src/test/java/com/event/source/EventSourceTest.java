package com.event.source;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.event.source.EventSource;
import com.event.source.model.SimpleEvent;
import com.event.source.subscriber.EventSubscriber;

public class EventSourceTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	private EventSource eventSource;

	@Before
	public void init() {
		System.setOut(new PrintStream(this.outContent));
		this.eventSource = EventSource.getInstance();
	}

	@Test
	public void subcriberTest() {
		new EventSubscriber();
		String inputValue = "Simple event";
		this.eventSource.publish(new SimpleEvent(inputValue));
		assertThat(inputValue + "\n", equalTo(outContent.toString()));
	}
}
