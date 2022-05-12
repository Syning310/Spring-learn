package com.syning.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class TestJedis {

    @Autowired
    StringRedisTemplate template;



    @Test
    public void testRedis() {

        ValueOperations<String, String> operations = template.opsForValue();

        operations.set("hello", "world");

        String hello = operations.get("hello");

        System.out.println("hello = " + hello);

    }


}
