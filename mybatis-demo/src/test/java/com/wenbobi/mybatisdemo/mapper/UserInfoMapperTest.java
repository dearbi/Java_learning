package com.wenbobi.mybatisdemo.mapper;

import com.wenbobi.mybatisdemo.model.UserInfo;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    void getList() {
        System.out.println(1121);
        List<UserInfo> list = userInfoMapper.getList();
        list.forEach(x->{
            System.out.println(x);
        });
    }

    @Test
    void getUserInfoById() {
        UserInfo userInfo = userInfoMapper.getUserInfoById(2);;
        System.out.println(userInfo);
    }

    @Test
    void insert() {
        UserInfo userInfo = new UserInfo("王五","12",12);
        Integer i =userInfoMapper.insert(userInfo);
        System.out.println("插入的行数："+i+"自增的id："+userInfo.getId());
    }

    @Test
    void deleteById() {
        Integer i = userInfoMapper.deleteById(2);
        System.out.println("删除的行数："+i);
    }


    @Test
    void update() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(6);
        userInfo.setUsername("王五");
        userInfoMapper.update(userInfo);
        System.out.println("更新的行数："+userInfoMapper.update(userInfo));
    }

    @Test
    void getListByOrder() {
        List<UserInfo> list = userInfoMapper.getListByOrder("asc");
        System.out.println(list);
    }
}