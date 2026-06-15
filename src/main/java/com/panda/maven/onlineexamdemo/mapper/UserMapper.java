package com.panda.maven.onlineexamdemo.mapper;

import com.panda.maven.onlineexamdemo.dto.UserDto;
import com.panda.maven.onlineexamdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
