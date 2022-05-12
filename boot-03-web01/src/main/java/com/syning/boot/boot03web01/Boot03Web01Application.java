package com.syning.boot.boot03web01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot03Web01Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot03Web01Application.class, args);

        System.out.printf("hello %d, next year be %d", 1, 2);
    }

}
