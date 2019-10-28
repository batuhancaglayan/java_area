package com.s3.io.tryer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsConfig {

//	@Bean
//	@Scope("prototype")
//	public S3ClientExtended getS3Client() {
//		ClientConfiguration clientConfiguration = new ClientConfiguration();
//		clientConfiguration.setConnectionTimeout(5000);
//		clientConfiguration.setSocketTimeout(25000);
//
//		S3ClientExtended client = new S3ClientExtended();
//
//		return client.withCredential(new AWSStaticCredentialsProvider(new BasicAWSCredentials("AKIAJBOLJ7U27E5VT62Q", "uRjwnRoHaQ+iRGjmqOnA0H9jyjqATh5vU5SeKeUO")))
//				.withRegion(Regions.US_EAST_2.toString()).withConfiguration(clientConfiguration).build();
//	}

	@Bean
	public AmazonS3 getS3Client() {

		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(
						new BasicAWSCredentials("AKIAJBOLJ7U27E5VT62Q", "uRjwnRoHaQ+iRGjmqOnA0H9jyjqATh5vU5SeKeUO")))
				.withRegion(Regions.US_EAST_2).build();

		return s3client;
	}
}
