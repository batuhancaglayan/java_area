package com.aspect.annotation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.aspect.annotation.tyrer.trigger.DenemeTrigger;
import com.aspect.annotation.user.trigger.Dale;

@SpringBootApplication
@ComponentScan("com.aspect")
public class AspectAnnotationUserApplication implements CommandLineRunner {

	@Autowired
	private Dale dale;
	
	public static void main(String[] args) {
		SpringApplication.run(AspectAnnotationUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		this.dale.dale();	
//		
//		Dale dale1 = new Dale();
//		dale1.dale();
//			
//		DenemeTrigger denemeTrigger = new DenemeTrigger();
//		denemeTrigger.trigger();
		
		DenemeTrigger denemeTrigger = new DenemeTrigger();
     	denemeTrigger.trigger();
		
		System.err.println("adwd");
	}
}
