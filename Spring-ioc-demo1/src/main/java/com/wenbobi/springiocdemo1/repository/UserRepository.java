package com.wenbobi.springiocdemo1.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void print(){
        System.out.println("I'm userRepository...");
    }
}
