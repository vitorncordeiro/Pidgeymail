package com.pidgeymail.userservice.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE = "user.exchange";
    public static final String ROUTING_KEY_USER_CREATED = "user.created";
    @Bean
    public JacksonJsonMessageConverter messageConverter(){
        return new JacksonJsonMessageConverter();
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE, true, false);
    }

}
