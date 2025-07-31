package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    /**
     * 用户状态 0停用 1启用
     */
    public static final Integer UNABLE = 0;
    public static final Integer ENABLE = 1;

    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer status;
}
