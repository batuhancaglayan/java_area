package com.lambda.function.tryer;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.google.gson.Gson;

public class App {

	private static AWSLambda awsLambda;

	private static Gson gson = new Gson();

	private static Person person = new Person("b2", "c2");

	public static void main(String[] args) {
		awsLambda = AWSLambdaClientBuilder.standard().withRegion("us-east-2").build();

		String personStr = gson.toJson(person);

		try {
			InvokeRequest invokeRequest = new InvokeRequest().withFunctionName("dnm-lambda-function")
					.withPayload(personStr);
			InvokeResult invokeResult = awsLambda.invoke(invokeRequest);
			Person resultPerson = gson.fromJson(new String(invokeResult.getPayload().array()), Person.class);
			System.out.println(resultPerson.getName());
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
