package com.wenbobi.springiocdemo1.controller;

import com.wenbobi.springiocdemo1.UserService.UserService;
import com.wenbobi.springiocdemo1.model.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@ResponseBody
@Controller
public class UserController {
    /**
     * 属性注入
     */
//    @Autowired
//    private UserService userService;

    /**
     * 构造方法注入
     */
//    private UserService userService;
//
//    public UserController() {
//    }
//
//    @Autowired
//    public UserController(UserService userService){
//        this.userService = userService;
//    }

    /**
     * Setter注入
     */
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }


    /**
     * Autowired 缺陷
     */
    @Autowired
    private UserService userService;

//    @Qualifier("userInfo2")
//    @Autowired

    @Resource(name = "userInfo")
    private UserInfo userInfo;

    @RequestMapping("/print")
    public void print() {
        userService.print();
        System.out.println(userInfo);
        System.out.println("I'm UserController...");
    }
}
