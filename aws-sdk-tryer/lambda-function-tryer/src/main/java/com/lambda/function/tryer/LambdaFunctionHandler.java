package com.lambda.function.tryer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.stream.Collectors;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.google.gson.Gson;

public class LambdaFunctionHandler implements RequestStreamHandler {

	private Gson gson = new Gson();

	@Override
	public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {

		String requestString = streamToString(input);
		System.out.println(requestString);

		try {
			final String responseString = this.gson.toJson(new Person("b1", "c1"));
			output.write(responseString.getBytes(Charset.forName("UTF-8")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static String streamToString(InputStream input) {
		return new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining("\n"));
	}
}
