package com.panda.maven.onlineexamdemo.service;

import com.panda.maven.onlineexamdemo.entity.Exam;

import java.util.List;

public interface IExamService {
    List<Exam> getByCourseName(String courseName);
}
