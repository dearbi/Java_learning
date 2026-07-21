package com.wenbobi.springiocdemo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("proper")
public class PropertiesController {
    @Value("${my.key}")
    private String myKey;

    @Value("${count}")
    private Integer count;
    @Value("${is.true}")
    private Boolean isTrue;

    @GetMapping("/getConfigValue")
    public String getConfigValue() {
        return "从配置中获取值myKey="+myKey+",count="+count+",isTrue="+isTrue;
    }

}
