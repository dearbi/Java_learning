package com.wenbobi.springmvc_demo1.controller;


import com.wenbobi.springmvc_demo1.model.MessageInfo;
import com.wenbobi.springmvc_demo1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    List<MessageInfo> messageInfoList=new ArrayList<>();

    @Autowired
    private MessageService messageService;


    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        return messageService.getList();
    }

    @RequestMapping(value = "/publish",produces = "application/json")
       public String publish(@RequestBody MessageInfo messageInfo){

        //参数校验
        if(!StringUtils.hasText(messageInfo.getFrom()) || !StringUtils.hasText(messageInfo.getTo()) ||
                !StringUtils.hasText(messageInfo.getMessage())){
            return "{\"ok\":0}";
        }
        Integer result=messageService.insertMessage(messageInfo);
        if(result==1) {
            return "{\"ok\":1}";
        }
        return "{\"ok\":0}";
    }
}
