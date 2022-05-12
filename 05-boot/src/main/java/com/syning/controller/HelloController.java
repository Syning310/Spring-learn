package com.syning.controller;

import com.syning.controller.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${hello.name:尚亦宁}")
    private String name;

    @Value("${hello.age}")
    private String age;


    @Autowired
    private Person person;



    @GetMapping("/hello")
    public String hello() {

        return "hello " + name + "  " + age;
    }




    @GetMapping("/person")
    public String person() {

        return person.getClass().toString();
    }



}
