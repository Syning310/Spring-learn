package com.syning.boot.boot03web01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping("/thy")
    public String thy(Model model) {

        model.addAttribute("message", "你好尚亦宁");

        return "success";
    }




}
