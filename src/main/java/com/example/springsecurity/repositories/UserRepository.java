package com.example.springsecurity.repositories;

import com.example.springsecurity.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByLogin(String login);
}
