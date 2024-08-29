package com.user.Users.dto;

public record UserDto(
        Long id,
        String username,
        String password,
        String email
) {
}
