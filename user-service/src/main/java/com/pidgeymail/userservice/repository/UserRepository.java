package com.pidgeymail.userservice.repository;

import com.pidgeymail.userservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository <UserModel, UUID> {
}
