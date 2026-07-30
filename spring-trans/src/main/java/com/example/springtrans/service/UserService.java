package com.example.springtrans.service;

import com.example.springtrans.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    public void registryUser(String name,String password){
        userInfoMapper.insert(name,password);
    }
}
