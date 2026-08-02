package com.example.springtheory.config;

import com.example.springtheory.model.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DogBeanConfig {
    @Bean
    public Dog dog(){
        Dog dog=new Dog();
        dog.setName("旺财");
        return dog;
    }
}
