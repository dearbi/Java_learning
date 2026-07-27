package com.wenbobi.springmvc_demo2.model;

import lombok.Data;

@Data
public class UserInfo {
    private Integer id;
    private String username;
    private String password;
    private Integer deleteFlag;
    private String createTime;
    private String updateTime;
}
