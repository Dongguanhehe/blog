package com.example.blog.dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class LoginFormDTO {
    @Email
    private String email;
    private String code;
    private String password;
}
