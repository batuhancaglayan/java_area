package com.aspect.annotation.user.trigger;

import org.springframework.stereotype.Component;

import com.aspect.annotation.tyrer.annotation.DenemeAnnotation;
import com.aspect.annotation.tyrer.trigger.DenemeTrigger;

@Component
public class Dale {

	@DenemeAnnotation(persistenceClass = DenemeTrigger.class)
	public void dale() {	
		System.err.println("dale");
	}
}
