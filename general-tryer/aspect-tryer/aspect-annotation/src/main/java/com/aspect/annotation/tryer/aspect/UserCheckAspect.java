package com.aspect.annotation.tryer.aspect;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserCheckAspect {

	@Around("@annotation(com.aspect.annotation.tryer.annotation.UserCheck)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    return joinPoint.proceed();
	}
}
