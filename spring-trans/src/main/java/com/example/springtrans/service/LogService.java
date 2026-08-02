package com.example.springtrans.service;

import com.example.springtrans.mapper.LogInfoMapper;
import com.example.springtrans.model.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogService {

    @Autowired
    private LogInfoMapper logInfoMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertLogInfo(String name,String op){
        int a=10/0;
        logInfoMapper.insert(name,op);
    }
}
