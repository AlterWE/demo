package com.example.demo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserLoginVO {
    private String userName;
    private String name;
    private String token;

}
