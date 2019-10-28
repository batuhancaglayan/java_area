package com.aws.sns.tryer.listener;

import org.springframework.stereotype.Component;

import com.amazonaws.services.sns.message.SnsMessageHandler;
import com.amazonaws.services.sns.message.SnsNotification;
import com.amazonaws.services.sns.message.SnsSubscriptionConfirmation;
import com.amazonaws.services.sns.message.SnsUnknownMessage;
import com.amazonaws.services.sns.message.SnsUnsubscribeConfirmation;

@Component
public class SnsHandlerImpl extends SnsMessageHandler {

	@Override
	public void handle(SnsNotification message) {
		System.err.println(message.getMessage());

	}

	@Override
	public void handle(SnsSubscriptionConfirmation message) {
		System.err.println(message.getMessage());

	}

	@Override
	public void handle(SnsUnsubscribeConfirmation message) {
		System.err.println(message.getMessage());

	}

	@Override
	public void handle(SnsUnknownMessage message) {
		System.err.println(message.getTimestamp());
	}
}
