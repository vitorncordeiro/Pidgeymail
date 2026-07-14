package com.pidgeymail.userservice.dto;

public record UserRequest(
        String password,
        String username,
        String email
) {
}
