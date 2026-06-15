package com.panda.maven.onlineexamdemo.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private String gender;
    private String phone;
    private String name;
    private String college;
    private Integer courses;
    private String password;
    private String role;
}
