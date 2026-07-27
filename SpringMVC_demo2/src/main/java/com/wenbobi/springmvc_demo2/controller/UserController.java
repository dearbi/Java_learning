package com.wenbobi.springmvc_demo2.controller;

import com.wenbobi.springmvc_demo2.service.UserService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public boolean login(String name, String password) {
        /**
         * 1. 参数校验
         * 2. 验证密码
         * 3. 返回
         */

        log.info("用户登录,name:{}", name);
        if (!StringUtils.hasText(name) || !StringUtils.hasText(password)) {
            log.info("用户登录,name或password为空");
            return false;
        }

        //根据名称查询用户信息，判断密码是否正确
//        //TODO 当前未学习数据库，暂且写死
//        if ("admin".equals(name) && "123456".equals(password)) {
//            return true;
//        }

        return userService.checkPassword(name, password);

    }
}
