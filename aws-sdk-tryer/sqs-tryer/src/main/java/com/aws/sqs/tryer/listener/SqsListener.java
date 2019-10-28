package com.aws.sqs.tryer.listener;

import java.util.List;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

@Component
public class SqsListener {

	private AmazonSQS sqs;

	@PostConstruct
	private void init() {
		try {
			ProfileCredentialsProvider profileCredentialsProvider = new ProfileCredentialsProvider();
			this.sqs = AmazonSQSClientBuilder.standard().withCredentials(profileCredentialsProvider)
					.withRegion(Regions.US_EAST_2).build();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Scheduled(fixedDelay = 3000)
	public void scheduleFixedDelayTask() {
		//System.err.println("scheduleFixedDelayTask");
		List<Message> messages = this.sqs.receiveMessage("https://sqs.us-east-2.amazonaws.com/902703094694/dnm-sqs")
				.getMessages();
		if (messages == null || messages.isEmpty()) {
			return;
		}

		for (Message message : messages) {
			for (Entry<String, String> item : message.getAttributes().entrySet()) {
				System.err.println(item.getKey() + " => " + item.getValue());
			}
			
			System.err.println(message.getBody());
		}
	}
}
