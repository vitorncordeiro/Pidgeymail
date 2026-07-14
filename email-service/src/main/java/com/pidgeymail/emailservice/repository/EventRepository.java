package com.pidgeymail.emailservice.repository;

import com.pidgeymail.emailservice.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<EventModel, UUID> {}
