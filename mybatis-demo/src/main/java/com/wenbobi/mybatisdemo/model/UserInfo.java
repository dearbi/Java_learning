package com.wenbobi.mybatisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@Data
public class UserInfo {
    /*        `id` INT ( 11 ) NOT NULL AUTO_INCREMENT,
        `username` VARCHAR ( 127 ) NOT NULL,
        `password` VARCHAR ( 127 ) NOT NULL,
        `age` TINYINT ( 4 ) NOT NULL,
        `gender` TINYINT ( 4 ) DEFAULT '0' COMMENT '1-男 2-女 0-默认',
        `phone` VARCHAR ( 15 ) DEFAULT NULL,
        `delete_flag` TINYINT ( 4 ) DEFAULT 0 COMMENT '0-正常, 1-删除',
        `create_time` DATETIME DEFAULT now(),
        `update_time` DATETIME DEFAULT now() ON UPDATE now(),*/
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

    public UserInfo(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
