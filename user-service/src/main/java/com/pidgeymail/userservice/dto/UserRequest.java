package com.pidgeymail.userservice.dto;

public record UserRequest(
        String username,
        String email
) {
}
