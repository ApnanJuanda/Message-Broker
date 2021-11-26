package com.example.activemq.TopicSubscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@SpringBootApplication
@EnableMongoAuditing
public class TopicSubscriberApplication {

	public static void main(String[] args){
		SpringApplication.run(TopicSubscriberApplication.class, args);
		System.out.println("SubscriberApp is running!!");
	}

}
