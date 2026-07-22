package com.wenbobi.springiocdemo1.controller;

import com.wenbobi.springiocdemo1.model.Dbtypes;
import com.wenbobi.springiocdemo1.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yml")
public class YmlController {
    @Value("${string.hello}")
    private String hello;

    @Autowired
    private Student student;

    @Autowired
    private Dbtypes dbtypes;

//    @RequestMapping("/getConfigValue")
    @PostConstruct
    public String getConfigValue(){
        System.out.println(student);
        System.out.println(dbtypes);
        return "hello:"+hello;
    }
}
