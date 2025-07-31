package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.UserLoginDTO;
import com.example.demo.entity.UserLoginVO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        UserLoginVO userLoginVO = userService.login(userLoginDTO);
        if(userLoginVO!=null){
            return Result.success(userLoginVO,"Login successful");
        }else{
            return Result.error("Invalid username or password");
        }
    }
}
