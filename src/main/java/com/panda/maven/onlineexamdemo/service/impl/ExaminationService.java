package com.panda.maven.onlineexamdemo.service.impl;

import com.panda.maven.onlineexamdemo.entity.Course;
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
}
