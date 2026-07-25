package com.wenbobi.mybatisdemo.mapper;

import com.wenbobi.mybatisdemo.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperXMLTest {

    @Autowired
    UserInfoMapperXML userInfoMapperXML;

    @Test
    void getList() {
        System.out.println(userInfoMapperXML.getList());
    }

    @Test
    void getUserInfoById() {
        System.out.println(userInfoMapperXML.getUserInfoById(1));
    }

    @Test
    void insert() {
        userInfoMapperXML.insert(new UserInfo("test","123456",18));
        System.out.println(userInfoMapperXML.getList());
    }
}