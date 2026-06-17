package com.panda.maven.onlineexamdemo.service;


import com.panda.maven.onlineexamdemo.dto.ConditionDto;

import java.util.List;

public interface IConditionService {
    List<ConditionDto> list();

    void getByUsername(String conditionRequest);
}
