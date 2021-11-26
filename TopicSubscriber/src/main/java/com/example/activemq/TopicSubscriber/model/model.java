package com.example.activemq.TopicSubscriber.model;


public class model {
	public String topic_destination;
	public String message;

    public model(String topic_destination, String message) {
    	this.topic_destination = topic_destination;
    	this.message = message;
    }
}