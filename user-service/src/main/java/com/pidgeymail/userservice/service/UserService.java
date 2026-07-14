package com.pidgeymail.userservice.service;

import com.pidgeymail.userservice.dto.UserRequest;
import com.pidgeymail.userservice.event.UserCreatedEvent;
import com.pidgeymail.userservice.messaging.UserEventPublisher;
import com.pidgeymail.userservice.model.UserModel;
import com.pidgeymail.userservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserEventPublisher userEventPublisher;
    @Transactional
    public void create(UserRequest request){
        var userModel = userRepository.save(UserModel.builder()
                .password(request.password())
                .email(request.email())
                .build());
        userEventPublisher.publish(
                new UserCreatedEvent(userModel.getId().toString(), userModel.getUsername(),
                        userModel.getEmail(), userModel.getCreatedAt())
        );
    }
}
