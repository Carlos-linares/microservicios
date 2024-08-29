package com.user.Users.dto;

public record UserToSaveDto(
        Long id,
        String username,
        String password,
        String email
) {
}
