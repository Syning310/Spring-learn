package com.syning.controller;

import com.syning.except.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptController {

    @GetMapping("/div0")
    public String div0() {

        int i = 10 / 0;

        return "index";
    }


    @GetMapping("/tooMany")
    public String tooMany() {


        throw new UserTooManyException();
    }


}
