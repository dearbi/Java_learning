package com.wenbobi.springmvc_demo1;


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

    @RequestMapping("/getList")
    public List<MessageInfo> getList() {
        return messageInfoList;
    }

    @RequestMapping(value = "/publish",produces = "application/json")
       public String publish(@RequestBody MessageInfo messageInfo){

        //参数校验
        if(!StringUtils.hasText(messageInfo.getFrom()) || !StringUtils.hasText(messageInfo.getTo()) ||
                !StringUtils.hasText(messageInfo.getMessage())){
            return "{\"ok\":0}";
        }
        messageInfoList.add(messageInfo);
        return "{\"ok\":1}";
    }
}
