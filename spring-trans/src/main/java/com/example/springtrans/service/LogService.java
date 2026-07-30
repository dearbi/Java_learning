package com.example.springtrans.service;

import com.example.springtrans.mapper.LogInfoMapper;
import com.example.springtrans.model.LogInfo;

public class LogService {

    private LogInfoMapper logInfoMapper;

    public void insertLogInfo(String name,String op){
        logInfoMapper.insert(name,op);
    }
}
