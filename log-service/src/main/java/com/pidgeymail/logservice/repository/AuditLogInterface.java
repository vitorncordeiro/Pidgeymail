package com.pidgeymail.logservice.repository;

import com.pidgeymail.logservice.model.AuditLogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditLogInterface extends JpaRepository<AuditLogModel, UUID> {}
