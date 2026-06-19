package com.panda.maven.onlineexamdemo.service.impl;


import com.panda.maven.onlineexamdemo.controller.request.LoginRequest;
import com.panda.maven.onlineexamdemo.dto.LoginDto;
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

    @Resource
    UserMapper userMapper;

    @Override
    public LoginDto login(LoginRequest request) {
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

        LoginDto loginDto = new LoginDto();

        String token = TokenUtils.genToken(user.getUsername(), user.getPassword());
        loginDto.setToken(token);
        BeanUtils.copyProperties(user, loginDto);
        return loginDto;

    }

    @Override
    public UserDto getByUsername(String username) {return userMapper.getByUsername(username);}

    @Override
    public User getByUsername1(String username) {return userMapper.getByUsername1(username);}

    @Override
    public void change(User newStu) {
        if (!newStu.getRole().equals(userMapper.getByUsername(newStu.getUsername()).getRole())){
            throw new ServiceException("你不能修改该信息");
        }
        userMapper.change(newStu);

        if (newStu.getCourseIds() != null){
            userMapper.deleteById(newStu.getCourse());
            userMapper.insertByIds(newStu.getCourse(),newStu.getCourseIds());
        }
    }

}
