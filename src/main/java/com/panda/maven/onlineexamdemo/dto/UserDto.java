package com.panda.maven.onlineexamdemo.dto;


import com.panda.maven.onlineexamdemo.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String name;
    private String gender;
    private String phone;
    private String username;
    private String college;
    private String role;
    private List<Course> courses;
}
