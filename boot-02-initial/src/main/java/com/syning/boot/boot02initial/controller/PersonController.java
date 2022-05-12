package com.syning.boot.boot02initial.controller;

import com.syning.boot.boot02initial.javabean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person() {
        return person;
    }



}
