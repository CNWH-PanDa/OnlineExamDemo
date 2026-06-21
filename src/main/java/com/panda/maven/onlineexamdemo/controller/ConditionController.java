package com.panda.maven.onlineexamdemo.controller;


import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.ConditionPageRequest;
import com.panda.maven.onlineexamdemo.entity.Condition;
import com.panda.maven.onlineexamdemo.service.IConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher/profile/exam")
public class ConditionController {

    @Autowired
    IConditionService conditionService;


    @GetMapping("/page")
    public Result page(ConditionPageRequest request){
        return Result.success(conditionService.page(request));
    }

    @GetMapping("/page/{courseName}")
    public Result selectByCourseName(@PathVariable("courseName") String courseName, @ModelAttribute Condition condition){
        return Result.success(conditionService.selectByUserName(courseName,condition.getUsername()));
    }

}
