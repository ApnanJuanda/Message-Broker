package com.example.activemq.TopicPublisher.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@Configuration
@EnableJms
public class publisherConfig{
	//Fill parameter connection
	@Value("${activemq.broker.url}")
	String brokerUrl;
	
	@Value("${activemq.broker.username}")
	String userName;
	
	@Value("${activemq.broker.password}")
	String password;
	
	/*Initial Connection*/
	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(brokerUrl);
		connectionFactory.setUserName(userName);
		connectionFactory.setPassword(password);
		return connectionFactory;
	}
	
	
	/*Used for sending message*/
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		//template.setMessageConverter(jacksonJmsMessageConverter());
		template.setPubSubDomain(true);
		return template;
	}
	
	
}