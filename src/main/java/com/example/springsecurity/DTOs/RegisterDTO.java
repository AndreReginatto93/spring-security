package com.example.springsecurity.DTOs;

import com.example.springsecurity.entities.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
