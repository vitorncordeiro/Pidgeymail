package com.pidgeymail.userservice.controller;

import com.pidgeymail.userservice.dto.UserRequest;
import com.pidgeymail.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest request) {
        userService.create(request);
        return ResponseEntity.ok("User created successfully");
    }
}
