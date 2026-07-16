package com.wenbobi.springbootdemo;

import tools.jackson.databind.ObjectMapper;

public class JackSonTest {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(18);

        //对象转为json
        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);

        String jsonStr = "{\"name\":\"zhangsan\",\"age\":18}";
        Person person1 = objectMapper.readValue(jsonStr, Person.class);
        System.out.println(person1);
    }
}
