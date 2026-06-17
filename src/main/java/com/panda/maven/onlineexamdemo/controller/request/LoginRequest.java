package com.panda.maven.onlineexamdemo.controller.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
