package com.wenbobi.springmvc_demo1.mapper;

import com.wenbobi.springmvc_demo1.model.MessageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageMapperTest {

    @Autowired
    MessageMapper messageMapper;

    @Test
    void selectList() {
        List<MessageInfo> messageInfoList = messageMapper.selectList();
        System.out.println(messageInfoList);
    }

    @Test
    void insertMessage() {
    }
}