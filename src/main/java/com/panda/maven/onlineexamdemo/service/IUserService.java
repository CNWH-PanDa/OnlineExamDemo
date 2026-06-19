package com.panda.maven.onlineexamdemo.service;


import com.panda.maven.onlineexamdemo.controller.request.LoginRequest;
import com.panda.maven.onlineexamdemo.dto.LoginDto;
import com.panda.maven.onlineexamdemo.dto.UserDto;
import com.panda.maven.onlineexamdemo.entity.User;


public interface IUserService {

    LoginDto login(LoginRequest request);

    UserDto getByUsername(String username);

    User getByUsername1(String username);

    void change(User newStu);
}
