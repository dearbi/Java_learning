package com.example.springtheory.config;

import com.example.springtheory.model.Dog;
import org.springframework.context.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DogBeanConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void dog() {
        Dog dog1 = applicationContext.getBean(Dog.class);
        System.out.println(dog1);
    }
}