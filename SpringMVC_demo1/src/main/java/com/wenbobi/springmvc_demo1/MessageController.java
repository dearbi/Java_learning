package com.wenbobi.springmvc_demo1;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    @RequestMapping("/test")
    public String test() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setFrom("admin");
        messageInfo.setTo("user");
        messageInfo.setMessage("hello user");
        return messageInfo.toString();
    }
}
