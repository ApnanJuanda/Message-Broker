package com.example.activemq.TopicSubscriber.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = subscriberModel.class)
public class subscriberModel{
	//private static final long serialVersionUID = 1L;
	
	private String topic_destination;
	private String message;
	
	public subscriberModel(){
    }
    
    public subscriberModel(String topic_destination, String message){
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