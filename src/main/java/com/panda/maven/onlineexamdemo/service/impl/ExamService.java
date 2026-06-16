package com.panda.maven.onlineexamdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.controller.request.BaseRequest;
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
        String subject = null;
        try {
            subject = examMapper.getById(id).getSubject();
        } catch (Exception e) {
            throw new ServiceException("该题不存在");
        }
        if (!subject.equals(courseName)){
            throw new ServiceException("无法在这里删除该题");
        }
        examMapper.deleteById(id);
    }

    @Override
    public void update(Exam exam, String courseName) {
        String subject = null;
        try {
            subject = examMapper.getById(exam.getQuestionId()).getSubject();
        } catch (Exception e) {
            throw new ServiceException("该题不存在");
        }
        if (!subject.equals(courseName)){
            throw new ServiceException("无法在这里更改该题");
        }

        examMapper.update(exam);
    }

    @Override
    public PageInfo<Exam> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Exam> list = examMapper.listByCondition(baseRequest);
        return new PageInfo<>(list);
    }


}
