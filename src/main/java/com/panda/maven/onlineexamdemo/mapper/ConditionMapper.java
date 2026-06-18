package com.panda.maven.onlineexamdemo.mapper;


import com.panda.maven.onlineexamdemo.controller.request.ConditionPageRequest;
import com.panda.maven.onlineexamdemo.dto.ConditionDto;
import com.panda.maven.onlineexamdemo.entity.Condition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface ConditionMapper {
    List<ConditionDto> list();

    List<ConditionDto> listByCondition(@Param("request") ConditionPageRequest request);

    List<Condition> selectByUserName(String courseName, String username);

    String selectBycourseName(String courseName);
}
