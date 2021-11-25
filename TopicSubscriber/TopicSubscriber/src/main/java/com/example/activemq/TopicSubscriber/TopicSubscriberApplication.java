package com.example.activemq.TopicSubscriber;

import javax.jms.JMSException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.JmsException;

@SpringBootApplication
public class TopicSubscriberApplication {

	public static void main(String[] args) throws JmsException, JMSException {
		SpringApplication.run(TopicSubscriberApplication.class, args);
		System.out.println("SubscriberApp is running!!");
	}

}
