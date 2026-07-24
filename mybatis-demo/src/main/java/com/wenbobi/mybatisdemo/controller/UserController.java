package com.wenbobi.mybatisdemo.controller;

import com.wenbobi.mybatisdemo.model.UserInfo;
import com.wenbobi.mybatisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getList")
    public List<UserInfo> getList() {
        return userService.getList();
    }
}
