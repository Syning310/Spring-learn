package com.syning.boot.boot04web02.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    @GetMapping(value = "/basic_table")
    public String toBasicTable() {
        int i = 1 / 0;
        return "/table/basic_table.html";
    }


    @GetMapping(value = "/dynamic_table")
    public String toDynamicTable() {

        return "/table/dynamic_table.html";
    }

    @GetMapping(value = "/commons")
    public String toCommons() {
        return "commons";
    }





}
