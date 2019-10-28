package com.spring.hystrix.tryer.deneme;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

@Service
@Scope("prototype")
public class DenemeClient {

	private AmazonSNS sns;
	
	public DenemeClient() {
	    ClientConfiguration cf = new ClientConfiguration();
		this.sns = AmazonSNSClientBuilder.standard().withRegion("us-east-2").build();
	}

	public void process(boolean state) throws Exception {
		if (state) {
			Thread.currentThread().sleep(6000);
			throw new Exception("aq");
		} else {
//			PublishRequest publishRequest = new PublishRequest("arn:aws:sns:us-east-2:902703094694:deneme-lambda-topic",
//					"dale don omar");
//			PublishResult result = sns.publish(publishRequest);
			//System.err.println(result.getMessageId());
			// Thread.currentThread().sleep(4000);
			//AWS.config.sslEnabled = false;
			
			Thread.currentThread().sleep(3000);
			System.out.println("state => " + state);
		}
	}
	
	public void kill() {
		this.sns.shutdown();
	}
}
