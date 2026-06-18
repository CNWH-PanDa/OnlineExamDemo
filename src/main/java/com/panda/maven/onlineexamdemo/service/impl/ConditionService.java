package com.panda.maven.onlineexamdemo.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.controller.request.ConditionPageRequest;
import com.panda.maven.onlineexamdemo.dto.ConditionDto;
import com.panda.maven.onlineexamdemo.entity.Condition;
import com.panda.maven.onlineexamdemo.entity.Exam;
import com.panda.maven.onlineexamdemo.exception.ServiceException;
import com.panda.maven.onlineexamdemo.mapper.ConditionMapper;
import com.panda.maven.onlineexamdemo.service.IConditionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionService implements IConditionService {


    @Resource
    ConditionMapper conditionMapper;



    @Override
    public List<ConditionDto> list() {
        return conditionMapper.list();
    }


    @Override
    public PageInfo<ConditionDto> page(ConditionPageRequest request) {
        PageHelper.startPage(request.getPageNum(),request.getPageSize());
        List<ConditionDto> list = conditionMapper.listByCondition(request);
        if (list.isEmpty()){
            throw new ServiceException("查询错误");
        }
        return new PageInfo<>(list);
    }

    @Override
    public List<Condition> selectByUserName(String courseName,String username) {
        return conditionMapper.selectByUserName(courseName,username);
    }
}
