package com.panda.maven.onlineexamdemo.mapper;

import com.panda.maven.onlineexamdemo.controller.request.BaseRequest;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamMapper {
    List<Exam> getByCourseName(String courseName);

    void addQues(Exam exam);

    Course getBySubject(String subject);

    Exam getById(Integer id);

    void deleteById(Integer id);

    void update(Exam exam);

    List<Exam> listByCondition(BaseRequest baseRequest);
}
