package com.panda.maven.onlineexamdemo.controller;


import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.ExaminationPageRequest;
import com.panda.maven.onlineexamdemo.dto.CourseDto;
import com.panda.maven.onlineexamdemo.service.IExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/examination/{username}")
public class ExaminationController {

    @Autowired
    IExaminationService examinationService;


    @GetMapping
    public Result list(@PathVariable("username") String username){
        List<CourseDto> list = examinationService.list(username);
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(@ModelAttribute ExaminationPageRequest examinationPageRequest,@PathVariable("username") String username){
        return Result.success(examinationService.getBySubject(examinationPageRequest,username));
    }

    @GetMapping("/page/test/{subject}")
    public Result test(@PathVariable("username") String username,@PathVariable("subject") String subject){
        return Result.success(examinationService.getBySub(username,subject));
    }


    @PostMapping("/page/test/{subject}/submit")
    public Result submit(@PathVariable("username") String username, @PathVariable("subject") String subject, @RequestBody Map<Integer,String> answers){
        Integer toScore = examinationService.submitExam(username,subject,answers);
        return Result.submitSuccess(toScore);
    }

}
