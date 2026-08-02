package com.example.springaop.controller;

import com.example.springaop.aspect.MyAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/t1")
    public String t1(){
        return "test";
    }

    @MyAspect
    @RequestMapping("/t2")
        public Integer t2(){
        return 12;
    }

    @RequestMapping("/t3")
        public Boolean t3(){
        return true;
    }
}
