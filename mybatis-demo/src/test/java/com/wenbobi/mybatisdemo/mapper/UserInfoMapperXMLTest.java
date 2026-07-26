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

    @Test
    void insertUserInfoByCondition() {
        UserInfo userInfo=new UserInfo();
        userInfo.setUsername("niuxxbi");
        userInfo.setPassword("niubi666");
        userInfo.setAge(18);
        userInfo.setGender(1);
        userInfoMapperXML.insertUserInfoByCondition(userInfo);
        System.out.println(userInfoMapperXML.getList());
    }

    @Test
    void queryByCondition() {
        UserInfo userInfo=new UserInfo();
//        userInfo.setAge(18);
        userInfo.setGender(1);
//        userInfo.setDeleteFlag(0);
        System.out.println(userInfoMapperXML.queryByCondition(userInfo));
    }
}