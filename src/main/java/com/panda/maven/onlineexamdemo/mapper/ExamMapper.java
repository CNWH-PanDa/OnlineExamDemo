package com.panda.maven.onlineexamdemo.mapper;

import com.panda.maven.onlineexamdemo.controller.request.ExamPageRequest;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamMapper {
    List<Exam> getByCourseName(String courseName);

    void addQues(Exam exam);

    Course getBySubject(String subject);

    Exam getByCourseName1(String username);

    void deleteById(Integer id);

    void update(Exam exam);

    List<Exam> listByCondition(@Param("examRequest") ExamPageRequest examRequest, @Param("courseName") String courseName);
}
