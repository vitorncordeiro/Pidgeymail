package com.pidgeymail.logservice.service;

import com.pidgeymail.logservice.event.UserCreatedEvent;
import com.pidgeymail.logservice.model.AuditLogModel;
import com.pidgeymail.logservice.repository.AuditLogInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AuditLogService {
    private final AuditLogInterface auditLogInterface;
    private final Logger log = LoggerFactory.getLogger(AuditLogService.class);

    public void registerUserCreatedEvent(UserCreatedEvent event,
    String routingKey){
        auditLogInterface.save(
                AuditLogModel.builder()
                        .userId(UUID.fromString(event.userId()))
                        .receivedRoutingKey(routingKey)
                        .timestamp(event.createdAt())
                        .build()
        );
        log.info("[AUDIT] routing-key={} userId={} email={} em={}",
                routingKey, event.userId(), event.email(), event.createdAt());
    }
}
