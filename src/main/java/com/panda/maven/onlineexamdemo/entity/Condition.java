package com.panda.maven.onlineexamdemo.entity;


import lombok.Data;

@Data
public class Condition {
    private Integer id;
    private String username;
    private String subject;
    private Integer score;
    private Integer testTime;

}
