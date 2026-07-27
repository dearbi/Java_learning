package com.wenbobi.springmvc_demo2.service;

import com.wenbobi.springmvc_demo2.mapper.UserInfoMapper;
import com.wenbobi.springmvc_demo2.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public boolean checkPassword(String name, String password) {
        UserInfo userInfo = userInfoMapper.queryUserInfoByName(name);
        if(userInfo==null || userInfo.getId()<1){
            log.info("用户登录,用户名不存在");
            return false;
        }

        return password.equals(userInfo.getPassword());
    }
}
