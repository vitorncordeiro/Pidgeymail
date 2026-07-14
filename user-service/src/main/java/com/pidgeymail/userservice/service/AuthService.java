package com.pidgeymail.userservice.service;

import com.pidgeymail.userservice.dto.UserRequest;
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

    public void register(UserRequest request) {

        if (repository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        UserModel user = new UserModel();
        user.setEmail(request.email());
        user.setPassword(
                passwordEncoder.encode(request.password())
        );
        user.setUsername(request.username());

        repository.save(user);
    }
}