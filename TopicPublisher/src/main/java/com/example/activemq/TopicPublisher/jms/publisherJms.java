package com.example.activemq.TopicPublisher.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import com.google.gson.Gson;

import com.example.activemq.TopicPublisher.model.publisherModel;

@Component
public class publisherJms{
	private static final Logger logger = LoggerFactory.getLogger(publisherJms.class);
	
    @Autowired
    JmsTemplate jmsTemplate;
    
	public void send(String destination, publisherModel message) {
		Gson gson = new Gson();
		String jsonMessage = gson.toJson(message);
		jmsTemplate.convertAndSend(destination, jsonMessage);
		logger.info("Message: {} published to topic: {} succesfully", jsonMessage, destination);
	
	}	
    
}