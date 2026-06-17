package com.panda.maven.onlineexamdemo.service;

import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.controller.request.BaseRequest;
import com.panda.maven.onlineexamdemo.controller.request.ExamPageRequest;
import com.panda.maven.onlineexamdemo.entity.Exam;

import java.util.List;

public interface IExamService {
    List<Exam> getByCourseName(String courseName);

    void addQues(Exam exam);

    void deleteById(Integer id,String courseName);

    void update(Exam exam, String courseName);

    PageInfo<Exam> page(BaseRequest baseRequest,String courseName);
}
