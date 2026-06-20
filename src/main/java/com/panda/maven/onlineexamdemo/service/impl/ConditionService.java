package com.panda.maven.onlineexamdemo.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.controller.request.ConditionPageRequest;
import com.panda.maven.onlineexamdemo.dto.ConditionDto;
import com.panda.maven.onlineexamdemo.entity.Condition;
import com.panda.maven.onlineexamdemo.exception.ServiceException;
import com.panda.maven.onlineexamdemo.mapper.ConditionMapper;
import com.panda.maven.onlineexamdemo.service.IConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionService implements IConditionService {


    @Autowired
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
        if (conditionMapper.selectBycourseName(courseName) == null ){
            throw new ServiceException("学生没有选择这门课");
        }
        List<Condition> list = conditionMapper.selectByUserName(courseName,username);
        if (list.isEmpty()){
            throw new ServiceException("学生没有考这门课");
        }
        return list;
    }
}
