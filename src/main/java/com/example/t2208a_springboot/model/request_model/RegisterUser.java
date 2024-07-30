package com.example.t2208a_springboot.model.request_model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUser {
    private String fullName;
    private String email;
    private String password;
}
