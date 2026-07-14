package com.pidgeymail.userservice.controller;

import com.pidgeymail.userservice.dto.UserRequest;
import com.pidgeymail.userservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody UserRequest request) {
        authService.register(request);
        return ResponseEntity.ok().body(request.username() + " registered successfully");
    }
}
