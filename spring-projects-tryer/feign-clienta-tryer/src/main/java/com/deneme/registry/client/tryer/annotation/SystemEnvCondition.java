package com.deneme.registry.client.tryer.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class SystemEnvCondition implements Condition {
	
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String abc = System.getenv("deneme");
		System.err.println(context.getEnvironment().getProperty("deneme"));
		return true;
	}
}
