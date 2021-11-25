package com.example.activemq.TopicSubscriber.model;


public class subscriberModel{
	
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