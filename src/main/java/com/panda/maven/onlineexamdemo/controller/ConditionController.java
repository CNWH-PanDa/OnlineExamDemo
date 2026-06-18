package com.panda.maven.onlineexamdemo.controller;


import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.ConditionPageRequest;
import com.panda.maven.onlineexamdemo.dto.ConditionDto;
import com.panda.maven.onlineexamdemo.entity.Condition;
import com.panda.maven.onlineexamdemo.service.IConditionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher/profile/exam")
public class ConditionController {

    @Resource
    IConditionService conditionService;


    @GetMapping("/list")
    public Result list(){
        List<ConditionDto> list = conditionService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(ConditionPageRequest request){
        return Result.success(conditionService.page(request));
    }

    @GetMapping("/page/{courseName}")
    public Result selectByCourseName(@PathVariable("courseName") String courseName, @RequestBody Condition condition){
        return Result.success(conditionService.selectByUserName(courseName,condition.getUsername()));
    }

}
