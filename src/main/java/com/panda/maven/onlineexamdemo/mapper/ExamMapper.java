package com.panda.maven.onlineexamdemo.mapper;

import com.panda.maven.onlineexamdemo.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamMapper {
    List<Exam> getByCourseName(String courseName);
}
