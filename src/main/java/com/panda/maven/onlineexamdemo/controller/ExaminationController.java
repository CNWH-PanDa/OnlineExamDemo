package com.panda.maven.onlineexamdemo.controller;


import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.ExaminationPageRequest;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.service.IExaminationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/examination")
public class ExaminationController {

    @Resource
    IExaminationService examinationService;


    @GetMapping("/{username}")
    public Result list(@PathVariable("username") String username){
        List<Course> list = examinationService.list(username);
        return Result.success(list);
    }

    @GetMapping("/{username}/page")
    public Result page(@RequestBody ExaminationPageRequest examinationPageRequest,@PathVariable("username") String username){
        return Result.success(examinationService.getBySubject(examinationPageRequest,username));
    }

    @GetMapping("/{username}/page/test")
    public Result test(@PathVariable("username") String username,@RequestBody Exam exam){
        return Result.success(examinationService.getBySub(username,exam.getSubject()));
    }
}
