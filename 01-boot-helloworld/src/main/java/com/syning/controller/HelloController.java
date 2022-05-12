package com.syning.controller;


import ch.qos.logback.classic.db.names.SimpleDBNameResolver;
import com.syning.entity.Car;
import com.syning.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;




// @Import 给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
@Import({Person.class, SimpleDBNameResolver.class})
@ConditionalOnBean(name = "ning")  // 当容器中有名为 ning 组件时，才会往容器中注入这个Controller控制器


@ImportResource(value = "classpath:beans01.xml")
@RestController(value = "hello")
public class HelloController {

    @Autowired
    private Car mycar;

    @GetMapping("/hello")
    public String handle01() {
        return "Hello Spring Boot 2";
    }



    @GetMapping("/mycar")
    public Car car() {
        return mycar;
    }

}
