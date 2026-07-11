package com.pidgeymail.userservice.service;

import com.pidgeymail.userservice.dto.UserRequest;
import com.pidgeymail.userservice.model.UserModel;
import com.pidgeymail.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void create(UserRequest request){
        userRepository.save(UserModel.builder()
                .username(request.username())
                .email(request.email())
                .build());
    }
}
