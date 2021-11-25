package com.example.activemq.TopicSubscriber.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.util.ErrorHandler;


@Configuration
public class subscriberConfig{
	@Value("${activemq.broker.url}")
	String brokerUrl;
	
	@Value("${activemq.broker.username}")
	String userName;
	
	@Value("${activemq.broker.password}")
	String password;
	
	/*
	 * Initial ConnectionFactory
	 */
    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(brokerUrl);
        connectionFactory.setUserName(userName);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }
    
    @Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_type");
	    return converter;
	}
    
	/*
     * Used for receiving Messages.
     */

    
//	@Bean
//	public JmsListenerContainerFactory<?> jsaFactory(ConnectionFactory connectionFactory,
//	                                                DefaultJmsListenerContainerFactoryConfigurer configurer) {
//	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//	    factory.setPubSubDomain(true);
//	    factory.setMessageConverter(jacksonJmsMessageConverter());
//	    configurer.configure(factory, connectionFactory);
//	    return factory;
//	}
	
	@Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            ConnectionFactory connectionFactory,
            ErrorHandler myErrorHandler) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setErrorHandler(myErrorHandler);
        factory.setPubSubDomain(true);
	    factory.setMessageConverter(jacksonJmsMessageConverter());
        return factory;
    }

    @Bean
    public ErrorHandler myErrorHandler() {
        return t -> {
            System.out.println("In error handler");
            t.printStackTrace();
        };
    }
	
}