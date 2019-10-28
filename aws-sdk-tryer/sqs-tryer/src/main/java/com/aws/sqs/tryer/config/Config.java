package com.aws.sqs.tryer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan(value = "com.aws.sqs.tryer.*")
public class Config {

}
