package com.panda.maven.onlineexamdemo.entity;


import lombok.Data;

import java.util.List;

@Data
public class Exam {
    private Integer questionId;
    private String type;
    private String content;
    private List<String> options;
    private String answer;
    private Integer score;
    private String subject;
}
