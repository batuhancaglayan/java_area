package com.aspect.annotation.user.console.tryer;

import com.aspect.annotation.tyrer.annotation.DenemeAnnotation;

public class Tryer {
	
	@DenemeAnnotation(persistenceClass = Tryer.class)
	public void tryer() {
		System.out.println("tryer");
	}
}
