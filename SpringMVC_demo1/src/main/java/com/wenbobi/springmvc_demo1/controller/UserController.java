package com.wenbobi.springmvc_demo1.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
        if(!StringUtils.hasText(userName) || !StringUtils.hasText(password)) {
            return false;
        }
        //TODO 暂时写死
        if("admin".equals(userName) && "123456".equals(password)) {
            session.setAttribute("userName", userName);
            return true;
        }
        return false;
    }




    @GetMapping("/getLoginUser")
    public String getLoginUser(HttpSession session) {
        String userName = (String) session.getAttribute("userName");
        if(userName == null) {
            return "未登录";
        }
        return userName;
    }
}
