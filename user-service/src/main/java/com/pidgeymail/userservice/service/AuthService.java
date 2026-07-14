package com.pidgeymail.userservice.service;

import com.pidgeymail.userservice.dto.UserRequest;
import com.pidgeymail.userservice.event.UserCreatedEvent;
import com.pidgeymail.userservice.messaging.UserEventPublisher;
import com.pidgeymail.userservice.model.UserModel;
import com.pidgeymail.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserEventPublisher userEventPublisher;

    public void register(UserRequest request) {

        if (repository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        UserModel userModel = new UserModel();
        userModel.setEmail(request.email());
        userModel.setPassword(
                passwordEncoder.encode(request.password())
        );
        userModel.setUsername(request.username());

        repository.save(userModel);
        userEventPublisher.publish(
                new UserCreatedEvent(userModel.getId().toString(), userModel.getUsername(),
                        userModel.getEmail(), userModel.getCreatedAt())
        );
    }
}