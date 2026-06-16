package com.panda.maven.onlineexamdemo.service;


import com.panda.maven.onlineexamdemo.controller.request.UserRequest;
import com.panda.maven.onlineexamdemo.dto.UserDto;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.User;

import java.util.List;

public interface IUserService {

    UserDto login(UserRequest request);

    User getByUsername(String username);

}
