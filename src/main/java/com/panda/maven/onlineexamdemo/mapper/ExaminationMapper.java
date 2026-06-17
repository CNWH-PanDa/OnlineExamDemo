package com.panda.maven.onlineexamdemo.mapper;

import com.panda.maven.onlineexamdemo.controller.request.ExaminationPageRequest;
import com.panda.maven.onlineexamdemo.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface ExaminationMapper {
    List<Course> getByUsername(String username);

    List<Course> listByCondition(String subject, String username);
}
