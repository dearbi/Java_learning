package com.wenbobi.springiocdemo1.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    public void print() {
        System.out.println("I'm UserConfiguration...");
    }
}
