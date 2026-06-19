package com.panda.maven.onlineexamdemo.entity;

import lombok.Data;
import java.util.List;

@Data
public class User {
    private String username;
    private String gender;
    private String phone;
    private String name;
    private String college;
    private Integer course;
    private String password;
    private String role;
    private List<Course> courses;
    private List<Integer> courseIds;
}
