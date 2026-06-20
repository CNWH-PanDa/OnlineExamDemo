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
import java.util.List;
import java.util.Map;

@Service
public class ExaminationService implements IExaminationService {

    @Autowired
    ExaminationMapper examinationMapper;

    @Override
    public List<CourseDto> list(String username) {
        List<CourseDto> list = examinationMapper.getByUsername(username);
        if (list.isEmpty()){
            throw new ServiceException("查询错误");
        }

        for (CourseDto course : list){
            Integer uid = examinationMapper.getByUN(username);
            Integer cid = examinationMapper.getBySJ(course.getCourseName());
            course.setStatus(examinationMapper.getByIds(uid,cid));
            course.setScore(examinationMapper.getByUsernameAndSubject(username,course.getCourseName()));
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
    public Integer totalScore(String username,String subject) {
        Integer score = examinationMapper.totalScore(username);
        examinationMapper.insert(username,subject,score);
        return score;
    }

    @Override
    public void submit(String username, Map<Integer,String> answer,String subject) {
        examinationMapper.submitAnswer(username,answer);
        Integer uid = examinationMapper.getByUN(username);
        Integer cid = examinationMapper.getBySJ(subject);
        examinationMapper.setStatus(uid,cid);
    }

}
