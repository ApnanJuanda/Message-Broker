package com.example.activemq.TopicSubscriber.jms;


import java.util.Calendar;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.activemq.TopicSubscriber.model.model;
import com.example.activemq.TopicSubscriber.model.messageModel;
import com.example.activemq.TopicSubscriber.repository.messageRepository;
import com.google.gson.Gson;

@Component
public class subscriberJms{
	private static final Logger logger = LoggerFactory.getLogger(subscriberJms.class);
	
	@Autowired
	messageRepository repository;
	
	@JmsListener(destination = "${activemq.destination.topic}", containerFactory = "jmsListenerContainerFactory")
	public void messageListener(TextMessage message) throws JMSException {		
		Gson gson = new Gson();
		String jsonMessage = gson.toJson(message.getText());
		model data = gson.fromJson(message.getText(), model.class);
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		messageModel mongo = new messageModel(data.topic_destination, data.message, now);
		repository.save(mongo); //save to mongoDB
		System.out.println(jsonMessage);
		System.out.println(data.message); 
		logger.info("Received '{}'", message.getText());
	}
}