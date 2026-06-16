package com.panda.maven.onlineexamdemo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;

@Data
public class Course {
    private Integer courseId;
    private String courseName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate createTime;
}
