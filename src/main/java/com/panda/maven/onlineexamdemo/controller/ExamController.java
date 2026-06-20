package com.panda.maven.onlineexamdemo.controller;


import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.ExamPageRequest;
import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher/profile/exam/{courseName}")
public class ExamController {

    @Autowired
    IExamService examService;


    @GetMapping()
    public Result exam(@PathVariable("courseName") String courseName){
        List<Exam> exam = examService.getByCourseName(courseName);
        return Result.success(exam);
    }

    @PostMapping("/addQues")
    public Result addQues(@RequestBody Exam exam,@PathVariable("courseName") String courseName){
        exam.setSubject(courseName);
        examService.addQues(exam);
        return Result.addSuccess();
    }

    @DeleteMapping("/delQues/{id}")
    public Result delQues(@PathVariable("id") Integer id,@PathVariable("courseName") String courseName){
        examService.deleteById(id,courseName);
        return Result.deleteSuccess();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Exam exam,@PathVariable("courseName") String courseName){
        examService.update(exam,courseName);
        return Result.updateSuccess();
    }

    @GetMapping("/page")
    public Result page(ExamPageRequest request,@PathVariable("courseName") String courseName){return Result.success(examService.page(request,courseName));}

}
