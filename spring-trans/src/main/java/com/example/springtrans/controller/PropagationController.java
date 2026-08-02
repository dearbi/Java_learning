package com.example.springtrans.controller;

import com.example.springtrans.service.LogService;
import com.example.springtrans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propaga")
public class PropagationController {

    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping("/p1")
    public String r3(String name,String password) {
        userService.registryUser(name,password);
        logService.insertLogInfo(name,"用户注册");
        return "success";
    }

}
