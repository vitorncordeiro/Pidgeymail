package com.pidgeymail.logservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name="audit_log")
@NoArgsConstructor
@Getter
@SuperBuilder
public class AuditLogModel {
    @Id
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "receivedRoutingKey")
    private String receivedRoutingKey;
    private Instant timestamp;
}
