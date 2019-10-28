package com.aws.dynamodb.tryer.connection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;

@Component
public class DynamodbConnection {

	private AmazonDynamoDB amazonDynamoDB;

	@PostConstruct
	private void init() {
		this.amazonDynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
	}

	public void queryToItem() {

		ListTablesResult listTablesResult = this.amazonDynamoDB.listTables();
		listTablesResult.getTableNames().stream().forEach(System.out::println);
		HashMap<String, AttributeValue> key_to_get = new HashMap<String, AttributeValue>();

		key_to_get.put("Artist", new AttributeValue("deneme-artist"));
		key_to_get.put("SongTitle", new AttributeValue("deneme-song"));
		

		Map<String, AttributeValue> items = this.amazonDynamoDB
				.getItem(new GetItemRequest().withTableName("Music").withKey(key_to_get)).getItem();

		for (Entry<String, AttributeValue> item : items.entrySet()) {
			System.err.println(item.getKey() + " => " + item.getValue());
		}
	}

	public void queryToItem(String key) {

//		HashMap<String,AttributeValue> key_to_get =
//			    new HashMap<String,AttributeValue>();
//
//			key_to_get.put("Name", new AttributeValue(name));

//	    Map<String,AttributeValue> returned_item =
//	    	       this.amazonDynamoDB.getItem(new GetItemRequest()
//	   			        .withKey(key)
//				        .withTableName("")).getItem();

	}

}
