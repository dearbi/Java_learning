package com.wenbobi.springbootdemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "/v1",method = {RequestMethod.GET,RequestMethod.POST})
    public String hello1() {
        return "hello world";
    }

    @RequestMapping("/v2")
    public int hello2() {
        return 3*2;
    }

    @GetMapping("/v3")
    public String hello3() {
        return "只支持GET";
    }
    @PostMapping("/v4")
    public String hello4() {
        return "只支持POST";
    }
}
