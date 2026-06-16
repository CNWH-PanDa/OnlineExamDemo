package com.panda.maven.onlineexamdemo.controller;


import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.service.IExamService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamController {

    @Resource
    IExamService examService;


    @GetMapping("/teacher/profile/exam/{courseName}")
    public Result exam(@PathVariable("courseName") String courseName){
        List<Exam> exam = examService.getByCourseName(courseName);
        return Result.success(exam);
    }

}
