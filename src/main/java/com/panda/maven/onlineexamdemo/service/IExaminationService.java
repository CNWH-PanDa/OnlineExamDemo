package com.panda.maven.onlineexamdemo.service;

import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.BaseRequest;
import com.panda.maven.onlineexamdemo.controller.request.ExaminationPageRequest;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;

import java.util.List;

public interface IExaminationService {
    List<Course> list(String username);

    PageInfo<Course> getBySubject(ExaminationPageRequest examRequest, String username);

    List<Exam> getBySub(String username, String subject);
}
