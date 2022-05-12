package com.syning.boot.boot05web03.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping(value = "/sql")
    public String queryFormDB() {
        Long along = jdbcTemplate.queryForObject("select count(*) from book", Long.class);

        return along.toString();
    }



    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

}
