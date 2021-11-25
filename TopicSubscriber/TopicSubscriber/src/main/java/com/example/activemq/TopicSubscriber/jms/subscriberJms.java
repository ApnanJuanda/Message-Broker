package com.example.activemq.TopicSubscriber.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.activemq.TopicSubscriber.model.subscriberModel;

@Component
public class subscriberJms{
	private static final Logger logger = LoggerFactory.getLogger(subscriberJms.class);
	@JmsListener(destination = "${activemq.destination.topic}")
	public void messageListener(subscriberModel message) {
		logger.info("Message Received: {}", message.toString());
		logger.error(null);
	}
}