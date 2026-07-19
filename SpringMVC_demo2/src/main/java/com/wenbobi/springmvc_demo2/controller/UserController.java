package com.wenbobi.springmvc_demo2.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public boolean login(String name,String password){
        /**
         * 1. 参数校验
         * 2. 验证密码
         * 3. 返回
         */

        if(!StringUtils.hasText(name) || !StringUtils.hasText(password)){
            return false;
        }

        //TODO 当前未学习数据库，暂且写死
        if("admin".equals(name) && "123456".equals(password)){
            return true;
        }

        return false;
    }
}
