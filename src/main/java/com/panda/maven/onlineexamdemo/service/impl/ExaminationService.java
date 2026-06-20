package com.panda.maven.onlineexamdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.controller.request.ExaminationPageRequest;
import com.panda.maven.onlineexamdemo.dto.CourseDto;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.exception.ServiceException;
import com.panda.maven.onlineexamdemo.mapper.ExaminationMapper;
import com.panda.maven.onlineexamdemo.service.IExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ExaminationService implements IExaminationService {

    @Autowired
    ExaminationMapper examinationMapper;

    @Override
    public List<CourseDto> list(String username) {
        List<CourseDto> list = examinationMapper.getCourseDetailsWithStatusAndScore(username);
        if (list.isEmpty()){
            throw new ServiceException("查询错误");
        }

        return list;
    }

    @Override
    public PageInfo<Course> getBySubject(ExaminationPageRequest examinationRequest, String username) {
        PageHelper.startPage(examinationRequest.getPageNum(),examinationRequest.getPageSize());
        List<Course> courses = examinationMapper.listByCondition(examinationRequest.getSubject(),username);
        if (courses.isEmpty()){
            throw new ServiceException("查询错误");
        }
        return new PageInfo<>(courses);
    }

    @Override
    public List<Exam> getBySub(String username, String subject) {
//        Integer uid = examinationMapper.getByUN(username);
//        Integer cid = examinationMapper.getBySJ(subject);
//        if (examinationMapper.getByIds(uid,cid) == 1){
//            throw new ServiceException("你已经考过了");
//        }
        return examinationMapper.getBySub(username,subject);
    }

    @Override
    @Transactional
    public Integer submitExam(String username, String subject, Map<Integer, String> answers) {
        examinationMapper.submitAnswer(username,answers);
        Integer score = examinationMapper.totalScore(username,subject);
        Integer uid = examinationMapper.getByUN(username);
        Integer cid = examinationMapper.getBySJ(subject);
        examinationMapper.setStatus(uid,cid);
        if (score == null) {
            examinationMapper.insert(username,subject,0);
            return 0;
        }
        examinationMapper.insert(username,subject,score);

        return score;
    }
}
