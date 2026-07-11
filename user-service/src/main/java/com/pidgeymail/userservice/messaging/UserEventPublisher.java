package com.pidgeymail.userservice.messaging;

import com.pidgeymail.userservice.config.RabbitMQConfig;
import com.pidgeymail.userservice.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventPublisher {
    private final RabbitTemplate rabbitTemplate;

    public void publish(UserCreatedEvent event){
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY_USER_CREATED,
                event
        );
    }
}
