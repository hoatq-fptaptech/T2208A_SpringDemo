package com.example.t2208a_springboot.controller;

import com.example.t2208a_springboot.entity.User;
import com.example.t2208a_springboot.model.request_model.LoginUser;
import com.example.t2208a_springboot.model.request_model.RegisterUser;
import com.example.t2208a_springboot.model.response_model.LoginResponse;
import com.example.t2208a_springboot.service.AuthService;
import com.example.t2208a_springboot.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;
    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUser request){
        System.out.println(request);
        User registeredUser = authService.signUp(request);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUser request){
        User user = authService.login(request);
        String jwt = jwtService.generateToken(user);
        LoginResponse res = new LoginResponse()
                            .setToken(jwt)
                            .setExpiresIn(jwtService.getExpirationTime());
        return ResponseEntity.ok(res);
    }
}
