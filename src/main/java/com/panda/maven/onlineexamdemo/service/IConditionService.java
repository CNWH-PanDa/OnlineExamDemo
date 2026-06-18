package com.panda.maven.onlineexamdemo.service;


import com.github.pagehelper.PageInfo;
import com.panda.maven.onlineexamdemo.controller.request.ConditionPageRequest;
import com.panda.maven.onlineexamdemo.dto.ConditionDto;
import com.panda.maven.onlineexamdemo.entity.Condition;

import java.util.List;

public interface IConditionService {
    List<ConditionDto> list();

    PageInfo<ConditionDto> page(ConditionPageRequest request);

    List<Condition> selectByUserName(String courseName,String username);
}
