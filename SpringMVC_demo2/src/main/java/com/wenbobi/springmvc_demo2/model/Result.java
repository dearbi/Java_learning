package com.wenbobi.springmvc_demo2.model;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String errMsg;
    private T data;
}
