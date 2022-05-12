package com.syning.boot.controller;


import com.syning.boot.bean.Car;
import com.syning.boot.bean.Person;
import com.syning.boot.bean.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



// @Import 给容器中自动创建(无参构造)出这两个类型的组件 {Person.class, Pet.class}
// 默认组件的名字是 全类名
@Import({Person.class, Pet.class})
// 这个注解是 @ResponseBody 和 @Controller 的合体
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping(value = "/hello")
    public String handle01() {
        return "Hello, SpringBoot2!" + ", 你好";
    }


    @RequestMapping(value = "/car")
    public Car retCar() {
        return car;
    }






}
