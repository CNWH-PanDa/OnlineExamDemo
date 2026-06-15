package com.panda.maven.onlineexamdemo.controller;



import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.UserRequest;
import com.panda.maven.onlineexamdemo.dto.UserDto;
import com.panda.maven.onlineexamdemo.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Resource
    IUserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserRequest request){
        UserDto loginDto = userService.login(request);
        return Result.loginSuccess(loginDto);
    }
}
