package com.syning.controller;


import com.syning.entity.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @GetMapping("/1.jpg")
    public String hello1() {
        return "aaa";
    }


    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-尚亦宁";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-尚亦宁";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-尚亦宁";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-尚亦宁";
    }




    @PostMapping("/saveperson")
    public Person saveperson(Person person) {

        return person;
    }





}
