package com.wenbobi.springmvc_demo1.service;

import com.wenbobi.springmvc_demo1.mapper.MessageMapper;
import com.wenbobi.springmvc_demo1.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public List<MessageInfo> getList() {
        return messageMapper.selectList();
    }

    public Integer insertMessage(MessageInfo messageInfo) {
        return messageMapper.insertMessage(messageInfo);
    }
}
