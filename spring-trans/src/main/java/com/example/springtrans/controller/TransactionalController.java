package com.example.springtrans.controller;

import com.example.springtrans.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/trans")
public class TransactionalController {
    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping("/registry")
    public String registry(String name,String password){
        userService.registryUser(name,password);
        log.info("用户插入输入成功！");
        //对异常进行捕获
        try {
            int a=10/0;//制造异常
        }catch (Exception e){
            e.printStackTrace();
            log.error("注册失败！",e);
        }
        return "注册成功";
    }

    @Transactional
    @RequestMapping("/r2")
    public String r2(String name,String password) throws IOException {
        userService.registryUser(name,password);
        log.info("用户插入输入成功！");
        if(true){
            throw new IOException();
        }
        return "注册成功";
    }
}
