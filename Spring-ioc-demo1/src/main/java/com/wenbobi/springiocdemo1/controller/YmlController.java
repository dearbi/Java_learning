package com.wenbobi.springiocdemo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yml")
public class YmlController {
    @Value("${string.hello}")
    private String hello;
    @RequestMapping("/getConfigValue")
    public String getConfigValue(){
        return "hello:"+hello;
    }
}
