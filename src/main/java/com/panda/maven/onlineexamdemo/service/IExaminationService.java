package com.panda.maven.onlineexamdemo.service;

import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.controller.request.ExaminationPageRequest;
import com.panda.maven.onlineexamdemo.dto.CourseDto;
import com.panda.maven.onlineexamdemo.entity.Answer;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;

import java.util.List;
import java.util.Map;

public interface IExaminationService {
    List<CourseDto> list(String username);

    PageInfo<Course> getBySubject(ExaminationPageRequest examRequest, String username);

    List<Exam> getBySub(String username, String subject);

    Integer submitExam(String username, String subject, Map<Integer, String> answers);
}
