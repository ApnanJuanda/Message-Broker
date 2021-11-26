package com.example.activemq.TopicSubscriber.model;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="message")
public class messageModel {
	private String topic_from;
	private String message;
	@CreatedDate
    private LocalDate created;
	
	public messageModel(){
		
    }
	
	public messageModel(String topic_from, String message){
    	this.topic_from = topic_from;
    	this.message = message;
    }
    
    public messageModel(String topic_from, String message, LocalDate created){
    	this.topic_from = topic_from;
    	this.message = message;
    	this.created = created;
    }
	
	public String getTopic_from() {
		return topic_from;
	}
	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	public void setTopic_from(String topic_from) {
		this.topic_from = topic_from;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@Override
	public String toString() {
		return "messageModel [topic_from=" + topic_from + ", message=" + message + "]";
	}
	
}