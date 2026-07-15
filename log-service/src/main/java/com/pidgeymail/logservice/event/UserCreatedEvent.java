package com.pidgeymail.logservice.event;

import java.time.Instant;

public record UserCreatedEvent(
        String userId,
        String name,
        String email,
        Instant createdAt
) {
}
