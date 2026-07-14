package com.pidgeymail.emailservice.service;

import com.pidgeymail.emailservice.repository.EventRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WelcomeEmailService {
    private static final Logger log = LoggerFactory.getLogger(WelcomeEmailService.class);
    private final EventRepository eventRepository;
    private final TemplateEngine templateEngine;
    private final SmtpEmailSender smtpEmailSender;

    public void sendWelcomeEmail(UUID eventId, String name, String email) throws MessagingException {
        eventRepository.findById(eventId).ifPresent(event -> {
            log.info("Event with ID " + eventId + " already exists.");
        });
        String html = generateHtml(name);
        smtpEmailSender.send(email, html);
    }

    private String generateHtml(String name){
        Context context = new Context();
        context.setVariable("username", name);
        String html = templateEngine.process(
                "emails/welcome",
                context
        );
        return html;
    }


}
