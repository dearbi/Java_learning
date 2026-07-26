package com.wenbobi.mybatisdemo.service;

import com.wenbobi.mybatisdemo.mapper.UserInfoMapper;
import com.wenbobi.mybatisdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getList() {
        return userInfoMapper.getList();
    }
}