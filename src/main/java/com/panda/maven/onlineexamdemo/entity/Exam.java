package com.panda.maven.onlineexamdemo.entity;


import lombok.Data;

@Data
public class Exam {
    private Integer questionId;
    private String type;
    private String content;
    private String options;
    private String answer;
    private Integer score;
    private String subject;
}
