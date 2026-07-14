package com.pidgeymail.emailservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "event")
public class EventModel {
    @Id
    @Column(name = "event_id", nullable = false, updatable = false)
    UUID eventId;
    @CreationTimestamp
    Instant createdAt;
}
