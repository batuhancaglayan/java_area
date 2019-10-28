package com.user.registration.system.util;

import org.springframework.stereotype.Component;

@Component
public class MailServiceUtil {

	public boolean sendActivationMail(String email, Long id) {
		System.out.println("activation mail send to user email => " + email);
		return true;
	}

	public boolean sendNotifyMail(String email, Long id) {
		System.out.println("Notify mail send to user email=> " + email + " user id => " + id);
		return true;
	}
}
