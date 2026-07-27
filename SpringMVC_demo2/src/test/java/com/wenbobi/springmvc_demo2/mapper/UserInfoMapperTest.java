package com.wenbobi.springmvc_demo2.mapper;

import com.wenbobi.springmvc_demo2.model.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void queryUserInfoByName() {
        UserInfo userInfo = userInfoMapper.queryUserInfoByName("admin");
        System.out.println(userInfo);
    }
}