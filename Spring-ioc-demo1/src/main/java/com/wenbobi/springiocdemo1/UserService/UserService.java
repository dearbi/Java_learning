package com.wenbobi.springiocdemo1.UserService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void print(){
        System.out.println("I'm UserService...");
    }

}
