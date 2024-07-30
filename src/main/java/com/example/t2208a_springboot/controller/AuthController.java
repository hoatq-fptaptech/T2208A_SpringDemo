package com.example.t2208a_springboot.controller;

import com.example.t2208a_springboot.entity.User;
import com.example.t2208a_springboot.model.request_model.RegisterUser;
import com.example.t2208a_springboot.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUser request){
        System.out.println(request);
        User registeredUser = authService.signUp(request);
        return ResponseEntity.ok(registeredUser);
    }
}
