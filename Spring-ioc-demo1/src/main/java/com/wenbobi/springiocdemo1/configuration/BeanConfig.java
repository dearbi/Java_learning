package com.wenbobi.springiocdemo1.configuration;

import com.wenbobi.springiocdemo1.model.UserInfo;
import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {
    @Bean
    public UserInfo userInfo(){
        UserInfo userInfo=new UserInfo(1,"wenbobi");
        return userInfo;
    }

    @Bean
    public UserInfo userInfo2(){
        UserInfo userInfo=new UserInfo(2,"wenbobi2");
        return userInfo;
    }

}
