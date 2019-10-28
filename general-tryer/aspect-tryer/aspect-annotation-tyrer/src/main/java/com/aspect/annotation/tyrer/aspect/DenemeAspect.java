package com.aspect.annotation.tyrer.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.aspect.annotation.tyrer.annotation.DenemeAnnotation;

@Aspect
public class DenemeAspect {
	
	public DenemeAspect() {
		System.out.println("DenemeAspect");
	}

	//@AfterReturning("@annotation(com.aspect.annotation.tyrer.annotation.DenemeAnnotation)")
	@Around("@annotation(com.aspect.annotation.tyrer.annotation.DenemeAnnotation)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("returning");
		return joinPoint.proceed();
	}
}
