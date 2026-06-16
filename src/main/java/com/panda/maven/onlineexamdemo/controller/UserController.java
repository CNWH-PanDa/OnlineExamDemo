package com.panda.maven.onlineexamdemo.controller;



import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.UserRequest;
import com.panda.maven.onlineexamdemo.dto.UserDto;
import com.panda.maven.onlineexamdemo.entity.User;
import com.panda.maven.onlineexamdemo.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserController {

    @Resource
    IUserService userService;

    @PostMapping("/auth/login")
    public Result login(@RequestBody UserRequest request){
        UserDto loginDto = userService.login(request);
        return Result.loginSuccess(loginDto);
    }

    @GetMapping("/teacher/profile")
    public Result teacherProfile(@RequestBody UserRequest request){
        User teacher = userService.getByUsername(request.getUsername());
        return Result.success(teacher);
    }


}
