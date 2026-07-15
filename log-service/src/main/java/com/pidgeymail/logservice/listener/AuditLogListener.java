package com.pidgeymail.logservice.listener;

import com.pidgeymail.logservice.event.UserCreatedEvent;
import com.pidgeymail.logservice.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuditLogListener {
    private final AuditLogService service;

    @RabbitListener(queues = "log.queue")
    public void receiveMessage(UserCreatedEvent message,
        @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String routingKey) {
        service.registerUserCreatedEvent(message, routingKey);
    }
}
