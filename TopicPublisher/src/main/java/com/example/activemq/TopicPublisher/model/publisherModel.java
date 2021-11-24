package com.example.activemq.TopicPublisher.model;

import java.io.Serializable;

public class publisherModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String topic_destination;
	private String message;
	
	
	    
	public String getTopic_destination() {
		return topic_destination;
	}

	public void setTopic_destination(String topic_destination) {
		this.topic_destination = topic_destination;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	@Override
    public String toString() {
        return "SystemMessage{" +
                "topic_destination='" + topic_destination + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
	
	
}