package com.example.activemq.TopicSubscriber.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection="message")
public class messageModel {
	private String topic_from;
	private String message;
//	@CreatedDate
//    private Date created;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date created = new Date();
	
	public messageModel(){
		
    }
	
	public messageModel(String topic_from, String message){
    	this.topic_from = topic_from;
    	this.message = message;
    }
    
    public messageModel(String topic_from, String message, Date created){
    	this.topic_from = topic_from;
    	this.message = message;
    	this.created = created;
    }
	
	public String getTopic_from() {
		return topic_from;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
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