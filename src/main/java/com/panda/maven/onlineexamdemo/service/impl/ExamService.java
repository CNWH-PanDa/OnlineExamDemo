package com.panda.maven.onlineexamdemo.service.impl;

import cn.hutool.core.util.StrUtil;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.exception.ServiceException;
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

    Exam exam;

    @Override
    public List<Exam> getByCourseName(String courseName) {
        List<Exam> exam = examMapper.getByCourseName(courseName);
        if (exam.isEmpty()){
            throw new ServiceException("没有对应试题");
        }
        return exam;
    }

    @Override
    public void addQues(Exam exam) {
        if (examMapper.getBySubject(exam.getSubject()) == null){
            throw new ServiceException("该门课程不存在");
        }
        examMapper.addQues(exam);
    }

    @Override
    public void deleteById(Integer id,String courseName) {
        if (examMapper.getBySubject(courseName) == null){
            throw new ServiceException("该门课程不存在");
        }

        Exam ex = examMapper.getById(id);
        if (ex == null) {
            throw new ServiceException("没有对应试题");
        }

        examMapper.deleteById(id);
    }


}
