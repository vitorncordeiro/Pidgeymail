package com.pidgeymail.logservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.JacksonJsonMessageConverter;

@Configuration
public class RabbitMQConfig {
    private final String QUEUE = "log.queue";
    private final String EXCHANGE = "user.exchange";
    private final String BINDING_KEY = "user.#";

    public static final String DLX = "log.dlx";
    public static final String DLQ = "log.queue.dlq";
    public static final String DLQ_ROUTING_KEY = "log.dlq";

    @Bean
    Queue logQueue(){
        return QueueBuilder.durable(QUEUE)
                .withArgument("x-dead-letter-exchange", DLX)
                .withArgument("x-dead-letter-routing-key", DLQ_ROUTING_KEY)
                .build();
    }

    @Bean
    public Queue logDeadLetterQueue() {
        return QueueBuilder.durable(DLQ).build();
    }
    @Bean
    public TopicExchange userExchange(){
        return new TopicExchange(EXCHANGE, true, false);
    }
    @Bean
    public DirectExchange logDeadLetterExchange() {
        return new DirectExchange(DLX, true, false);
    }
    @Bean
    public Binding logBinding(Queue logQueue, TopicExchange userExchange){
        return BindingBuilder.bind(logQueue).to(userExchange).with(BINDING_KEY);
    }
    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter() {
        return new JacksonJsonMessageConverter();
    }
}
