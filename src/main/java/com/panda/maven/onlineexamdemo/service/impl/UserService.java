package com.panda.maven.onlineexamdemo.service.impl;


import cn.hutool.crypto.SecureUtil;
import com.panda.maven.onlineexamdemo.controller.request.UserRequest;
import com.panda.maven.onlineexamdemo.dto.UserDto;
import com.panda.maven.onlineexamdemo.entity.User;
import com.panda.maven.onlineexamdemo.exception.ServiceException;
import com.panda.maven.onlineexamdemo.mapper.UserMapper;
import com.panda.maven.onlineexamdemo.service.IUserService;
import com.panda.maven.onlineexamdemo.utils.TokenUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService implements IUserService {

    public static final String PASS_SALT = "PanDa";

    @Resource
    UserMapper userMapper;

    @Override
    public UserDto login(UserRequest request) {
        User user = null;
        try {
            user = userMapper.selectByUsernameAndPassword(request.getUsername(), request.getPassword());
        } catch (Exception e) {
            log.error("根据用户名{}查询出错",request.getUsername());
            throw new ServiceException("用户名错误");
        }
        if (user == null){
            throw new ServiceException("用户名或密码错误");
        }


        UserDto userDto = new UserDto();

        String token = TokenUtils.genToken(user.getUsername(), user.getPassword());
        userDto.setToken(token);
        BeanUtils.copyProperties(user,userDto);
        return userDto;

    }

}
