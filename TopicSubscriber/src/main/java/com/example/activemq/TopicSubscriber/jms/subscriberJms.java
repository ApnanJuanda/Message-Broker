package com.example.activemq.TopicSubscriber.jms;


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
		messageModel mongo = new messageModel(data.message, data.topic_destination);
		/*mongo.setCreated(new Date());
		mongo.setMessage(data.message);
		mongo.setTopic_from(data.topic_destination);*/
		repository.save(mongo);
		System.out.println(data.message); 
		
		System.out.println(jsonMessage);
		logger.info("Received '{}'", message.getText());
	}
}