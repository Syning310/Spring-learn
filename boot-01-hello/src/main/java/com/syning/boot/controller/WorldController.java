package com.syning.boot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @RequestMapping(value = "/w")
    public String world() {
        return "你好 World!";
    }



}
