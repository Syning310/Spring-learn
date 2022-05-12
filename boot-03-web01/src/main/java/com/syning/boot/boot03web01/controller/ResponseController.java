package com.syning.boot.boot03web01.controller;


import com.syning.boot.boot03web01.javabean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {


    @GetMapping(value = "/test/person")
    public Person getPerson() {
        Person person = new Person("宁", 20);



        return person;
    }



}
