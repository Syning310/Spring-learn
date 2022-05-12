package com.syning.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping(value = "/redis1")
    public String testRedis() {
        // 设置值到 redis 中
        redisTemplate.opsForValue().set("name", "宁");

        // 从 redis 中获取值
        Object name = redisTemplate.opsForValue().get("name");

        return (String) name;
    }



}
