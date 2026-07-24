package com.wenbobi.captchademo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    @RequestMapping("/print")
    public String print(){
        logger.error("我是ERROR级别日志");
        logger.warn("我是WARN级别日志");
        logger.info("我是打印的日志");
        logger.debug("我是DEBUG级别日志");
        logger.trace("我是TRACE级别日志");
        return "success";
    }
}
