package com.example.trazabilidad.controller;

import com.example.trazabilidad.dtos.AuthDto;
import com.example.trazabilidad.dtos.UserCreateDto;
import com.example.trazabilidad.dtos.UserDto;
import com.example.trazabilidad.dtos.UserLoginDto;
import com.example.trazabilidad.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserCreateDto user) {
        ResponseEntity<UserDto> response;
        try {
            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body(authService.save(user));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDto> login(@RequestBody UserLoginDto user) {

        //return authService.login(user);
        return null;
    }


}
