package com.pidgeymail.emailservice.listener;

import com.pidgeymail.emailservice.event.UserCreatedEvent;
import com.pidgeymail.emailservice.service.WelcomeEmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WelcomeEmailListener {
    private final WelcomeEmailService emailService;

    @RabbitListener(queues = "email.queue")
    public void listen(UserCreatedEvent message) throws MessagingException {
        emailService.sendWelcomeEmail(message.userId(), message.name(), message.email());
    }
}
