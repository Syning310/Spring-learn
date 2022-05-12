package com.syning.boot.boot03web01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


    @RequestMapping(value = "/2.jpg")
    public String hello() {
        return "你好世界";
    }


//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping(value = "/user")
    public String getUser() {
        return "GET-宁";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping(value = "/user")
    public String saveUser() {
        return "POST-宁";
    }


//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping(value = "/user")
    public String putUser() {
        return "PUT-宁";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/user")
    public String deleteUser() {
        return "DELETE-宁";
    }


}
