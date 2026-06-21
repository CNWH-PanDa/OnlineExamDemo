package com.panda.maven.onlineexamdemo.mapper;

import com.panda.maven.onlineexamdemo.dto.UserDto;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper {

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    UserDto getByUsername(String username);

    User getByUsername1(String username);

//    Course getByCourseId(Integer courseId);

    void change(User newStu);

    void deleteById(Integer courseId);

    void insertByIds(Integer id,List<Integer> courseIds);
}
