package com.wenbobi.springmvc_demo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {
    @RequestMapping("/sum")
    public String sum(Integer num1, Integer num2) {
        if(num1 == null || num2 == null) {
            return "参数不合法";
        }
        int sum = num1 + num2;
        return "sum=" + sum;
    }
}

