package com.example.activemq.TopicSubscriber.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.activemq.TopicSubscriber.model.messageModel;


public interface messageRepository extends MongoRepository<messageModel, Integer>{
	
}