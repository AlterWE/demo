package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserLoginDTO;
import com.example.demo.entity.UserLoginVO;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserLoginVO login(UserLoginDTO userLoginDTO){
        //判断账号密码是否合法
        if (userLoginDTO.getUsername().length() < 4 || userLoginDTO.getUsername().length() > 16) {
            throw new IllegalArgumentException("账号长度需为4-16位");
        }
        if (userLoginDTO.getPassword().length() < 6) {
            throw new IllegalArgumentException("密码长度需为6-20位");
        }
        User user = userMapper.getByUserName(userLoginDTO.getUsername());
        //判断用户是否启用
        if(user==null|| Objects.equals(user.getStatus(), User.ENABLE)){
            return null;
        }
        //密码进行md5加密
        String password = DigestUtils.md5DigestAsHex(userLoginDTO.getPassword().getBytes());
        //与数据库的密码进行比对
        if(Objects.equals(user.getPassword(), password)){
            return UserLoginVO.builder()
                    .name(user.getName())
                    .userName(user.getUserName())
                    .token(UUID.randomUUID().toString())
                    .build();
        }else{
            return null;
        }
        //test git
    }
}
