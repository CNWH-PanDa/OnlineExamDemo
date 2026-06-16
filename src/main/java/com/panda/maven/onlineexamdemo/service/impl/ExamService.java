package com.panda.maven.onlineexamdemo.service.impl;

import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.mapper.ExamMapper;
import com.panda.maven.onlineexamdemo.service.IExamService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExamService implements IExamService {

    @Resource
    ExamMapper examMapper;

    @Override
    public List<Exam> getByCourseName(String courseName) {
        return examMapper.getByCourseName(courseName);
    }
}
