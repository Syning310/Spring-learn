package com.syning.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringBootStart {

    public static void main(String[] args) {

            ConfigurableApplicationContext run = SpringApplication.run(SpringBootStart.class, args);

    }



}
