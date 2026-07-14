package com.pidgeymail.emailservice.listener;

import com.pidgeymail.emailservice.event.UserCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WelcomeEmailListener {
    @RabbitListener(queues = "email.queue")
    public void listen(UserCreatedEvent message) {
        System.out.println("Received message: " + message);
    }
}
