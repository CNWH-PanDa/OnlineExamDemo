package com.panda.maven.onlineexamdemo.mapper;

import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User getByUsername(String username);

}
