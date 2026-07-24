package com.wenbobi.captchademo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import com.wenbobi.captchademo.model.CaptchaProperties;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {
    private final static long VALID_MILLS_TIME = 2 * 60 * 1000;

    @Autowired
    private CaptchaProperties captchaProperties;

    @GetMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());
        //TODO
        String code = lineCaptcha.getCode();
        System.out.println(code);
        session.setAttribute(captchaProperties.getSession().getCode(), code);
        session.setAttribute(captchaProperties.getSession().getDate(), new Date());

        //写出到浏览器
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");

        //图形验证码写出，可以写出到文件，也可以写出到流
        try {
            lineCaptcha.write(response.getOutputStream());
            response.getOutputStream().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 1. 参数校验
     * 2. 从session中获取code及其date，判断验证码是否正确以及是否过期
     * 3. 返回结果
     */
    @RequestMapping ("/verify")
    public boolean verify(String captcha, HttpSession session) {

        if(!StringUtils.hasText(captcha)){
            return false;
        }
        String savedCaptchaCode = (String) session.getAttribute(captchaProperties.getSession().getCode());
        Date savedCaptchaDate = (Date) session.getAttribute(captchaProperties.getSession().getDate());
        if(savedCaptchaCode == null || savedCaptchaDate == null){
            return false;
        }
        if(captcha.equalsIgnoreCase(savedCaptchaCode)){
            if(System.currentTimeMillis() - savedCaptchaDate.getTime() < VALID_MILLS_TIME){
                return true;
            }
        }
        return false;
    }
}
