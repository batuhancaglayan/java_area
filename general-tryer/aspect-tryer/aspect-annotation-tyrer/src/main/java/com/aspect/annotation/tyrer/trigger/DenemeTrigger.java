package com.aspect.annotation.tyrer.trigger;

import com.aspect.annotation.tyrer.annotation.DenemeAnnotation;

public class DenemeTrigger {
	
	@DenemeAnnotation(persistenceClass = DenemeTrigger.class)
	public String trigger() {
		return "trigger";
	}
}
