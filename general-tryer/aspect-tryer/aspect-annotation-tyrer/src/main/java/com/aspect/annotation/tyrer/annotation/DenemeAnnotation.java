package com.aspect.annotation.tyrer.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface DenemeAnnotation {

	public Class<?> persistenceClass();
}
