package com.syning.controller;


import com.syning.entity.Person;
import com.syning.entity.Pet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseTestController {
    /**
     *  1、浏览器发送请求直接返回 xml               [application/xml]         jacksonXmlConverter
     *  2、如果 ajax 请求，返回 json              [application/json]        jacksonJsonConverter
     *  3、如果 sy-ning 请求，返回自定义协议数据     [application/sy-ning]     xxxConverter
     *
     *  步骤：
     *  1、添加自定义的 MessageConverter 进系统底层
     *  2、系统底层就会统计出所有 MessageConverter 能操作哪些类型
     *  3、客户端内容协商 [sy-ning --> sy-ning]
     */
    @GetMapping("/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setName("宁");
        person.setAge("130000");
        Pet pet = new Pet();
        pet.setName("小白");
        pet.setWeight(55);
        person.setPet(pet);
        return person;
    }
}
