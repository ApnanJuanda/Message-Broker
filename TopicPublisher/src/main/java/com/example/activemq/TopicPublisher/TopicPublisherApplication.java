package com.example.activemq.TopicPublisher;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopicPublisherApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(TopicPublisherApplication.class, args);
		System.out.println("PublisherApp is running!!");
	}
	
	@Override
	public void run(String... args) throws Exception{
		
		
	}
	

}
