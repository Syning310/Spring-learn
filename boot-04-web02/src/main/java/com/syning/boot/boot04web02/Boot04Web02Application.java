package com.syning.boot.boot04web02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan    // 开启扫描原生 Servlet 组件
@SpringBootApplication
public class Boot04Web02Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot04Web02Application.class, args);
    }

}
