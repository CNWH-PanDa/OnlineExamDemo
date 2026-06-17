package com.panda.maven.onlineexamdemo.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String token;
    private String name;
    private String username;
    private String role;
}
