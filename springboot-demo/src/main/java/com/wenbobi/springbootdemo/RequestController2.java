package com.wenbobi.springbootdemo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/request2")
@RestController
public class RequestController2 {

    @RequestMapping("/getCookie")//通过HttpServletRequest获取Cookie
    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
        return "获取Cookie成功！";
    }

    @RequestMapping("/getCookie2")//通过Spring Boot的CookieValue注解获取Cookie值
    public String getCookie2(@CookieValue("dearbi") String name) {
        return "获取Cookie成功！_"+name;
    }
    @RequestMapping("/setSession")//通过HttpServletRequest设置Session
    public String setSession(HttpServletRequest request) {

        //true：如果没有Session，就创建一个Session
        //false：如果没有Session，则返回null，不创建Session对象
        HttpSession session = request.getSession(true);//如果没有Session，就创建一个Session
        session.setAttribute("name","dearbi");
        return "设置Session成功！";
    }
    @RequestMapping("/getSession")//通过HttpServletRequest获取Session
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);//如果没有Session，就创建一个Session
        String name = (String)session.getAttribute("name");
        return "获取Session成功！_"+name;
    }
    @RequestMapping("/getSession2")//通过HttpServletRequest获取Session
    public String getSession2(HttpSession session) {
        String name = (String)session.getAttribute("name");
        return "获取Session成功！_"+name;
    }
    @RequestMapping("/getSession3")//通过Spring Boot的SessionAttribute注解获取Session值
    public String getSession3(@SessionAttribute("name") String name) {
        return "获取Session成功！_"+name;
    }

    @RequestMapping("/getHeader")//通过HttpServletRequest获取请求头
    public String getHeader(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        return "获取header成功！_"+userAgent;
    }
    @RequestMapping("/getHeader2")//通过Spring Boot的RequestHeader注解获取请求头值
    public String getHeader2(@RequestHeader("user-agent") String userAgent) {
        return "获取header成功！_"+userAgent;
    }
}
