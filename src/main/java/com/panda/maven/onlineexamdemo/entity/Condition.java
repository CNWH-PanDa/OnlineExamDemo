package com.panda.maven.onlineexamdemo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Condition {
    private Integer id;
    private String username;
    private String subject;
    private Integer score;
    @JsonFormat(pattern = "yyyy-MM-dd HH:MM:SS",timezone = "GMT+8")
    private LocalDateTime testTime;

}
