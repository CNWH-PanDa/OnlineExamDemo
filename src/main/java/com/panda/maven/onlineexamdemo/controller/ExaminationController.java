package com.panda.maven.onlineexamdemo.controller;


import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.ExaminationPageRequest;
import com.panda.maven.onlineexamdemo.controller.request.SubmitRequest;
import com.panda.maven.onlineexamdemo.dto.CourseDto;
import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.service.IExaminationService;
import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examination/{username}")
public class ExaminationController {

    @Resource
    IExaminationService examinationService;


    @GetMapping()
    public Result list(@PathVariable("username") String username){
        List<CourseDto> list = examinationService.list(username);
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(@RequestBody ExaminationPageRequest examinationPageRequest,@PathVariable("username") String username){
        return Result.success(examinationService.getBySubject(examinationPageRequest,username));
    }

    @GetMapping("/page/test")
    public Result test(@PathVariable("username") String username,@RequestBody Exam exam){
        return Result.success(examinationService.getBySub(username,exam.getSubject()));
    }

    @PutMapping("/page/test/submit")
    @Transactional
    public Result submit(@PathVariable("username") String username, @RequestBody SubmitRequest request){
        examinationService.submit(username,request.getAnswers(),request.getExam().getSubject());
        Integer toScore = examinationService.totalScore(username,request.getExam().getSubject());
        return Result.submitSuccess(toScore);
    }

}
