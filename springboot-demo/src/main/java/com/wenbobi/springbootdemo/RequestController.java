package com.wenbobi.springbootdemo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class RequestController {
    /**
     * 接收一个参数
     * @param name
     * @return
     */
    @RequestMapping("/r1")
    public String r1(String name){
        return "接收到参数数，name:"+name;
    }

  /**
     * 接收多个参数
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("/r2")
    public String r2(String name,String password){
        return "接收到参数数，name:"+name+",password:"+password;
    }

    /**
     * 参数重命名
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/r3")
    public String r3(String name,String pwd){
        return "接收到参数数，name:"+name+",password:"+pwd;
    }
}
