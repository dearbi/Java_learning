package com.wenbobi.springbootdemo;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@ResponseBody
@Controller
@RequestMapping("/return")
public class ReturnController {

    /**
     * contentType: text/html;charset=UTF-8
     * 返回 HTML 页面
     * @return
     */
    @RequestMapping("/re1")
    public String re1(){
        return "/text.html";
    }

    //@ResponseBody 注解：将方法的返回值转换为 JSON 格式
    /**
     * contentType: application/json;charset=UTF-8
     * 返回 JSON 格式的字符串
     */
       @ResponseBody
    @RequestMapping("/re2")
    public String re2(){
        return "/text.html";
    }

    /**
     * contentType: text/html;charset=UTF-8
     * @return
     */
    @ResponseBody
    @RequestMapping("/re3")
    public String re3(){
        return "<h1>hello world</h1>";
    }

    /**
     * contentType: application/json;charset=UTF-8
     * @return
     */
    @ResponseBody
    @RequestMapping("/re4")
    public Person re4(){
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        return person;
    }

    //404 错误码不影响结果的展示

    /**
     * contentType: application/json;charset=UTF-8
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/re5")
    public Person re5(HttpServletResponse response){
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);
        response.setStatus(404);
        return person;
    }
    //可以指定返回的 contentType 类型
    @ResponseBody
    @RequestMapping(value = "/re6",produces = "application/json;charset=UTF-8")
    public String re6(){
        return "<h1>hello world</h1>";
    }

    //可以指定header
    @ResponseBody
    @RequestMapping(value = "/re7")
    public String re7(HttpServletResponse response){
        response.setHeader("My-Header","dearbi");
        return "<h1>hello world</h1>";
    }

}
