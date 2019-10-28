package com.garbage.spring.tryer.model;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.garbage.spring.tryer.model.Outer.Inner;

@Component
public class ContainerClass {

	private Outer outer;
	
	@PostConstruct
	private void init() {
		this.outer = new Outer();
	}
	
	public void trigger(String name) {
		Inner inner = this.outer.new Inner(name);
		inner.getName();
	}
}
