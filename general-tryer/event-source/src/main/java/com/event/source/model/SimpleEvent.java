package com.event.source.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SimpleEvent implements Event {

	private String name;
}
