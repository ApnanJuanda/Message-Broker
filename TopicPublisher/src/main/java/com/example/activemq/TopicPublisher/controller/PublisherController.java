package com.example.activemq.TopicPublisher.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.activemq.TopicPublisher.jms.publisherJms;
import com.example.activemq.TopicPublisher.model.publisherModel;

@RestController
	public class PublisherController {
	@Autowired
	publisherJms publisherJms;

		@PostMapping("/")
		public ResponseEntity<String> publishMessage(@RequestBody publisherModel message){
			try {
				System.out.println(message);
				publisherJms.send(message.getTopic_destination(), message);
				return new ResponseEntity<>("Success.", HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//Without status code and exception error
		/*public String sendMessage(@RequestBody publisherModel message) {
			publisherJms.send(destinationTopic, message);
			return "success";
		}*/
	}