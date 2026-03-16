package com.example.trazabilidad.services;

import com.example.trazabilidad.dtos.UserCreateDto;
import com.example.trazabilidad.dtos.UserDto;
import com.example.trazabilidad.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();
    Optional<UserDto> findById(Long id);
    Optional<UserDto> findByUserName(String userName);

    Optional<User> loadByUserName(String username);

    UserDto saveUser(UserCreateDto user);
    void deleteUser(Long id);
    UserDetails loadUserByUsername(String username);
}
