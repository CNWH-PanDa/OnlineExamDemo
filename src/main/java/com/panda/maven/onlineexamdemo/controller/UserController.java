package com.panda.maven.onlineexamdemo.controller;



import com.panda.maven.onlineexamdemo.common.Result;
import com.panda.maven.onlineexamdemo.controller.request.LoginRequest;
import com.panda.maven.onlineexamdemo.dto.LoginDto;
import com.panda.maven.onlineexamdemo.dto.UserDto;
import com.panda.maven.onlineexamdemo.entity.User;
import com.panda.maven.onlineexamdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/auth/login")
    public Result login(@RequestBody LoginRequest request){
        LoginDto loginDto = userService.login(request);
        return Result.loginSuccess(loginDto);
    }

    @GetMapping("/teacher/profile")
    public Result teacherProfile(@RequestBody LoginRequest request){
        UserDto teacher = userService.getByUsername(request.getUsername());
        return Result.success(teacher);
    }

    @GetMapping("/student/profile")
    public Result studentProfile(@RequestBody LoginRequest request){
        UserDto student = userService.getByUsername(request.getUsername());
        return Result.success(student);
    }

    @PutMapping("/student/profile/change")
    public Result changeProfile(@RequestBody User newStu){
        userService.change(newStu);
        return Result.updateSuccess();
    }


}
