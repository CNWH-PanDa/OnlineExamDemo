package com.panda.maven.onlineexamdemo.controller;


import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.service.IExaminationService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
