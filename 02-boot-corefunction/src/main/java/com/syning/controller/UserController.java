package com.syning.controller;

import com.syning.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/userinfo")
    public User info() {
        System.out.println(user);
        return user;
    }


}
