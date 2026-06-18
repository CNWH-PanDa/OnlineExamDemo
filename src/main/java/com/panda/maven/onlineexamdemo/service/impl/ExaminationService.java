package com.panda.maven.onlineexamdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.controller.request.BaseRequest;
import com.panda.maven.onlineexamdemo.controller.request.ExaminationPageRequest;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.exception.ServiceException;
import com.panda.maven.onlineexamdemo.mapper.ExaminationMapper;
import com.panda.maven.onlineexamdemo.service.IExaminationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExaminationService implements IExaminationService {



    @Resource
    ExaminationMapper examinationMapper;

    @Override
    public List<Course> list(String username) {
        List<Course> list = examinationMapper.getByUsername(username);
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
        return examinationMapper.getBySub(username,subject);
    }

}
