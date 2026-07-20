package com.wenbobi.springiocdemo1.component;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void print() {
        System.out.println("I'm UserComponent...");
    }
}
