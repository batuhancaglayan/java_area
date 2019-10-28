package com.aws.sns.tryer.listener;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeResult;

@Component
public class SnsListener {

	private AmazonSNS sns;

	@PostConstruct
	private void init() {
		this.sns = AmazonSNSClient.builder().withCredentials(new ProfileCredentialsProvider())
				.withRegion(Regions.US_EAST_2).build();
	}

	public void pushMessage(String message) {
		PublishResult publishResult = this.sns.publish("arn:aws:sns:us-east-2:902703094694:deneme-lambda-topic",
				message);
		System.err.println(publishResult.getMessageId());
//		SubscribeResult subscribeResult = this.sns.subscribe("", "", "");
//		subscribeResult.
//		new SnsMessageHandler(this.sns);
	}
}
