package com.example.activemq.TopicPublisher.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = publisherModel.class)
public class publisherModel{
	//private static final long serialVersionUID = 1L;
	
	private String topic_destination;
	private String message;
	
	public publisherModel(){
    }
    
    public publisherModel(String topic_destination, String message){
    	this.topic_destination = topic_destination;
    	this.message = message;
    }
	
	    
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