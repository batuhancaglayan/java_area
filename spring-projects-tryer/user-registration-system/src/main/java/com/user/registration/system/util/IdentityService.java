package com.user.registration.system.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.user.registration.system.exception.ServiceCallTimeOutException;

@Component
public class IdentityService {

	@Value("${mock.timeout}")
	private long mockTimeout;
	
	public boolean isIdentitfNoValid(long identityNo) throws ServiceCallTimeOutException {
		if (mockTimeout > 5000) {
			throw new ServiceCallTimeOutException("service call process take time out");
		}
		
		return true;
	}
}
