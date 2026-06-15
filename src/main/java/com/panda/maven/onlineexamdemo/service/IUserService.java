package com.panda.maven.onlineexamdemo.service;


import com.panda.maven.onlineexamdemo.controller.request.UserRequest;
import com.panda.maven.onlineexamdemo.dto.UserDto;

public interface IUserService {

    UserDto login(UserRequest request);
}
