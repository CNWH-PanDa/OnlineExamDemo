package com.panda.maven.onlineexamdemo.service;

import com.panda.maven.onlineexamdemo.entity.Course;

import java.util.List;

public interface IExaminationService {
    List<Course> list(String username);
}
