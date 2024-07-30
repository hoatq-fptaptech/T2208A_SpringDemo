package com.example.t2208a_springboot.service;

import com.example.t2208a_springboot.entity.User;
import com.example.t2208a_springboot.model.request_model.LoginUser;
import com.example.t2208a_springboot.model.request_model.RegisterUser;
import com.example.t2208a_springboot.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signUp(RegisterUser input){
        User user = new User()
                .setEmail(input.getEmail())
                .setFullName(input.getFullName())
                .setPassword(passwordEncoder.encode(input.getPassword()));
        return userRepository.save(user);
    }

    public User login(LoginUser input){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        User user = userRepository.findByEmail(input.getEmail());
        if(user == null)
            throw new UsernameNotFoundException("Email or password is not correct!");
        return user;
    }
}
