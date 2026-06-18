package com.panda.maven.onlineexamdemo.dto;

import com.panda.maven.onlineexamdemo.entity.Course;
import lombok.Data;

@Data
public class CourseDto extends Course {
    private Integer status;
    private Integer score;
}
